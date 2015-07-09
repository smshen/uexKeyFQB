package org.zywx.wbpalmstar.widgetone.key.fqb;


import java.util.Date;

import org.zywx.wbpalmstar.engine.universalex.EUExUtil;

import com.csii.powerenter.PEEditText;
import com.csii.powerenter.PEEditTextAttrSet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class KeyActivity extends Activity{

	public static String TAG ="KeyActivity";
	private OnClickedCallback callback;
	
	private PEEditText password ;
	
	
	String name= Constance.NAME;
	short bdtype=Constance.SOFT_BD_TYPE;
	boolean clearWhenOpenKbd= Constance.CLEAN_WHEN_OPEN_KBD;
	short softkbdMode=Constance.SOFT_BD_MODE;
	boolean kbdRandom=Constance.SOFT_BD_RANDOM;
	boolean kbdVibrator=Constance.SOFT_BD_VIBARATOR;
	short minLength=Constance.MIN_LENGTH;
	short maxLength=Constance.MAX_LENGTH;
	int encryptType=Constance.ENCRYPT_TYPE;
	char maskchar=Constance.MASK_CHAR;
	String publickey = Constance.PLATFORM_PUBLIC_KEY;
	boolean whenMaxCloseKbd=Constance.WHEN_MAX_CLOSE_KBD;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(EUExUtil.getResLayoutID("main"));
		
		init();
	}
	
	public void init(){
		
		password = (PEEditText) this.findViewById(EUExUtil.getResIdID("password"));
		
		PEEditTextAttrSet attr = new PEEditTextAttrSet();
		
		attr.name=name;
		attr.clearWhenOpenKbd=clearWhenOpenKbd;
		attr.softkbdType=bdtype;
		attr.softkbdMode=softkbdMode;
		attr.kbdRandom=kbdRandom;
		attr.kbdVibrator=kbdVibrator;
		attr.whenMaxCloseKbd=whenMaxCloseKbd;
		attr.minLength=minLength;
		attr.maxLength=maxLength;
		attr.encryptType=encryptType;
		attr.maskchar=maskchar;
		
		Constance.onToString();
		
		password.initialize(attr,KeyActivity.this);
		password.setHint(name);
		password.setPublicKey(publickey);
		
	} 
	
	public void getValue(){
		if (password!=null) {
			int v_check=password.validity_check();
			if(v_check==0){
//				Toast.makeText(KeyActivity.this, password.getValue(timeStamp), Toast.LENGTH_SHORT).show();
				Date date = new Date();
				Long  msec = date.getTime();
				String time = Long.toString(msec);
				Log.e("===time==", ""+time);
				Log.e("===pass==", ""+password.getValue(time));
				callback.getValue(password.getValue(Constance.TIMES_TEMP));
			}else if(v_check==-1)Toast.makeText(KeyActivity.this,"密码为空", Toast.LENGTH_SHORT).show();
	        else if(v_check==-2)Toast.makeText(KeyActivity.this,"密码长度小于最小长度", Toast.LENGTH_SHORT).show();
	        else if(v_check==-3)Toast.makeText(KeyActivity.this,"密码内容不合法", Toast.LENGTH_SHORT).show();
		}
	}

	public void setCallback(OnClickedCallback callback) {
		// TODO Auto-generated method stub
		this.callback = callback;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		password.onDestroy();
	}
	
}
