package org.zywx.wbpalmstar.widgetone.key.fqb;

import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.engine.universalex.EUExBase;


import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EUExKey extends EUExBase implements OnClickedCallback{

	private View marketDecorView;
	private KeyActivity mActivity;
	private static final String CB_RESULT = "uexKeyFQB.cbResult";
	public EUExKey(Context context, EBrowserView view) {
		super(context, view);
	}

	
	/***
	 * 打开输入框
	 * @param params
	 * p1:x
	 * p2:y
	 * p3:w
	 * p4:h
	 */
	public void openEditText(String[] params){
		if (params.length<5) {
			onToast("参数错误！");
		}
		int x=0;
		int y=0;
		int width=0;
		int height=0;
		String json="";
		try {
			 x = Integer.parseInt(params[0]);
			 y = Integer.parseInt(params[1]);
			 width = Integer.parseInt(params[2]);
			 height = Integer.parseInt(params[3]);
			 json = params[4];
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			onToast("参数错误！");
		}
		Constance.onSetData(json);
		openEditText(x, y, width, height);
		
	}
	
	@SuppressWarnings("deprecation")
	public void openEditText(final int x, final int y, final int width, final int height){
		
		((ActivityGroup)mContext).runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				// TODO Auto-generated method stub
				LocalActivityManager mgr = ((ActivityGroup) mContext)
						.getLocalActivityManager();
				if(mActivity==null && marketDecorView==null){
				Intent intent = new Intent(mContext, KeyActivity.class);
//				startActivity(intent);
				mgr.removeAllActivities();
				Window window = mgr.startActivity(
						KeyActivity.TAG, intent);
				marketDecorView = window.getDecorView();
				
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
						width, height);
				lp.leftMargin = x;
				lp.topMargin = y;
				addViewToCurrentWindow(marketDecorView, lp);
				KeyActivity activity = (KeyActivity) mgr.getActivity(KeyActivity.TAG);
				activity.setCallback(EUExKey.this);
				mActivity = activity;
				
				}
			}
		});
	}
	
	public void close(String[] params){
		if (mActivity!=null) {
			View decorView = mActivity.getWindow().getDecorView();
			removeViewFromCurrentWindow(decorView);
		}
	}
	public void getValue(String[] params){
		if (mActivity!=null) {			
			mActivity.getValue();
		}
	}
	public void onToast(String text){
		
		Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected boolean clean() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	/**
	 * 获取输入的加密之后的内容
	 */
	@Override
	public void getValue(String result) {
		// TODO Auto-generated method stub
		String js = SCRIPT_HEADER + "if(" + CB_RESULT + "){"
				+ CB_RESULT + "('" + result + "');}";
		onCallback(js);
	}
}
