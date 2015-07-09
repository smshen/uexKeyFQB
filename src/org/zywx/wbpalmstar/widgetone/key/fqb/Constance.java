package org.zywx.wbpalmstar.widgetone.key.fqb;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Color;
import android.util.Log;

public class Constance {
	
	
	//安全输入框的名字。默认名为CSII-POWERENTER
	public static String NAME;
	
	//字体颜色，初始化时指定。默认为黑色; 可使用Color.argb()得到想要的颜色值。
	public static int TEXT_COLOR;
	
	//密码控件显示的掩码，初始化时指定。默认为*，一般密码框为*、#等字符掩码。
	public static char MASK_CHAR;
	
	//软键盘类型， 初始化时指定。0：全键盘；1：数字键盘；2：全键盘与数字键盘互换模式。默认为全键盘。
	public static short SOFT_BD_TYPE;
	
	//设置软键盘按键DOWN时，按键是否变化。0： 变化  1： 不变化； 默认为0。
	public static short SOFT_BD_MODE;
	
	//可以接受的字符， 初始化时指定全字符。Accepts为正则表达式。默认“[:print:]+”
	public static String ACCEPTS;

	//最大长度，初始化时指定。默认为12，当输入内容达到最大长度内容时，将不能再输入
	public static short MAX_LENGTH;
	
	//最小长度，初始化时指定。默	为6，verify()方法会最小值判断输入内容是否满足要求
	public static short MIN_LENGTH;
	
	//设置软键盘按键位置是否随机，初始化时指定。可选值：true、false，默认选择随机（true）。
	public static boolean SOFT_BD_RANDOM;
	
	//设置触屏震动, 可选值：true、false,默认为false，触屏不震动
	public static boolean SOFT_BD_VIBARATOR;
	
	//启动键盘是，是否清空原来输入的内容。默认true
	public static boolean CLEAN_WHEN_OPEN_KBD;
	
	//当输入长度达到maxlength是否自动关闭键盘，默认false可选值：true、false
	public static boolean WHEN_MAX_CLOSE_KBD;
	
	//设置密码的加密类型，初始化时指定。
	public static int ENCRYPT_TYPE;
	
	//设置公钥
	public static String PLATFORM_PUBLIC_KEY;
	
	public static String TIMES_TEMP;
	
	public static final String KEY_NAME = "name"; 
	public static final String KEY_TEXT_COLOR = "textColor";
	public static final String KEY_MASK_CHAR = "maskChar";
	public static final String KEY_SOFT_BD_TYPE = "passwordKeyboardType";
	public static final String KEY_SOFT_BD_MODE = "softkbdMode";
	public static final String KEY_ACCEPTS = "accepts";
	public static final String KEY_MAX_LENGTH = "maxLength";
	public static final String KEY_MIN_LENGTH = "minLength";
	public static final String KEY_SOFT_BD_RANDOM = "isRoundam";
	public static final String KEY_SOFT_BD_VIBARATOR = "isVibration";
	public static final String KEY_CLEAN_WHEN_OPEN_KBD = "clearWhenOpenKbd";
	public static final String KEY_WHEN_MAX_CLOSE_KBD = "whenMaxCloseKbd";
	public static final String KEY_ENCRYPT_TYPE = "encryptType";
	public static final String KEY_PLATFORM_PUBLIC_KEY =  "platformPublicKey";
	public static final String KEY_TIMES_TEMP =  "timestamp";
	
	
	public static void onSetData(String str){
		try {
			JSONObject json = new JSONObject(str);
			if (json.has(KEY_NAME)) {
				NAME = json.getString(KEY_NAME);
			}else{
				NAME = "CSII-POWERENTER";
			}
			
			if (json.has(KEY_TEXT_COLOR)) {
				TEXT_COLOR =Color.parseColor(json.getString(KEY_TEXT_COLOR));
			}else{
				TEXT_COLOR = Color.BLACK;
			}
			
			if (json.has(KEY_MASK_CHAR)) {
				String s = json.getString(KEY_MASK_CHAR);
				
				MASK_CHAR = s.charAt(0);
			}else{
				MASK_CHAR = '*';
			}
			
			if (json.has(KEY_SOFT_BD_TYPE)) {
				SOFT_BD_TYPE = (short) json.getInt(KEY_SOFT_BD_TYPE);
			}else{
				SOFT_BD_TYPE = 0;
			}
			
			if (json.has(KEY_SOFT_BD_MODE)) {
				SOFT_BD_MODE = (short) json.getInt(KEY_SOFT_BD_MODE);
			}else{
				SOFT_BD_MODE = 0;
			}
			
			
			if (json.has(KEY_ACCEPTS)) {
				ACCEPTS = json.getString(KEY_ACCEPTS);
			}else{
				ACCEPTS = "[:print:]+";
			}
			
			if (json.has(KEY_MAX_LENGTH)) {
				MAX_LENGTH = (short) json.getInt(KEY_MAX_LENGTH);
			}else{
				MAX_LENGTH = 12;
			}
			
			if (json.has(KEY_MIN_LENGTH)) {
				MIN_LENGTH = (short) json.getInt(KEY_MIN_LENGTH);
			}else{
				MIN_LENGTH = 8;
			}
			
			if (json.has(KEY_SOFT_BD_RANDOM)) {
				SOFT_BD_RANDOM = json.getString(KEY_SOFT_BD_RANDOM).toCharArray().equals("YES")?true:false;
			}else{
				SOFT_BD_RANDOM = true;
			}
			
			
			if (json.has(KEY_SOFT_BD_VIBARATOR)) {
				SOFT_BD_VIBARATOR = json.getString(KEY_SOFT_BD_VIBARATOR).trim().equals("YES")?true:false;
			}else{
				SOFT_BD_VIBARATOR = false;
			}
			if (json.has(KEY_CLEAN_WHEN_OPEN_KBD)) {
				CLEAN_WHEN_OPEN_KBD = json.getBoolean(KEY_CLEAN_WHEN_OPEN_KBD);
			}else{
				CLEAN_WHEN_OPEN_KBD = true;
			}
			if (json.has(KEY_WHEN_MAX_CLOSE_KBD)) {
				WHEN_MAX_CLOSE_KBD = json.getBoolean(KEY_WHEN_MAX_CLOSE_KBD);
			}else{
				WHEN_MAX_CLOSE_KBD = false;
			}
			if (json.has(KEY_ENCRYPT_TYPE)) {
				ENCRYPT_TYPE =json.getInt(KEY_ENCRYPT_TYPE);
			}else{
				ENCRYPT_TYPE = 0;
			}
			
			if(json.has(KEY_PLATFORM_PUBLIC_KEY)){
				PLATFORM_PUBLIC_KEY = json.getString(KEY_PLATFORM_PUBLIC_KEY);
			}else{
				PLATFORM_PUBLIC_KEY="";
			}
			if (json.has(KEY_TIMES_TEMP)) {
				TIMES_TEMP = json.getString(KEY_TIMES_TEMP);
			}else{
				Date date = new Date();
				Long  msec = date.getTime();
				TIMES_TEMP=Long.toString(msec);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}catch(NumberFormatException e){
			
		}
	}
	public static void onToString(){
		Log.e("======", KEY_NAME+":"+NAME+"\n------"+KEY_MASK_CHAR+":"+MASK_CHAR+"\n-----"+KEY_TEXT_COLOR+":"+TEXT_COLOR+"\n------"
				+KEY_SOFT_BD_MODE+":"+SOFT_BD_MODE+"\n------"+KEY_SOFT_BD_TYPE+":"+SOFT_BD_TYPE+"\n------"+KEY_SOFT_BD_RANDOM+":"+SOFT_BD_RANDOM
				+"\n------"+KEY_SOFT_BD_VIBARATOR+":"+SOFT_BD_VIBARATOR+"\n------"+KEY_ACCEPTS+":"+ACCEPTS+"\n------"
				+KEY_MAX_LENGTH+":"+MAX_LENGTH+"\n------"+KEY_MIN_LENGTH+":"+MIN_LENGTH+"\n------"+KEY_CLEAN_WHEN_OPEN_KBD+":"+CLEAN_WHEN_OPEN_KBD
				+"\n------"+KEY_WHEN_MAX_CLOSE_KBD+":"+WHEN_MAX_CLOSE_KBD+"\n------"+KEY_ENCRYPT_TYPE+":"+ENCRYPT_TYPE+"\n-----"
				+KEY_PLATFORM_PUBLIC_KEY+":"+PLATFORM_PUBLIC_KEY);
	}
	
}
