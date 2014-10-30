//
//  CDVInMobi.m
//  InMobiPlugin
//
//  Created by Dmitriy Devayev on 10/8/14.
//
//

package org.apache.cordova.inmobi;

import java.util.Map;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitialListener;

public class CDVInMobi extends CordovaPlugin {
	
	public static final int AD_REQUEST_SUCCEEDED = 101;
	public static final int AD_REQUEST_FAILED = 102;
	public static final int ON_SHOW_MODAL_AD = 103;
	public static final int ON_DISMISS_MODAL_AD = 104;
	public static final int ON_LEAVE_APP = 105;
	public static final int ON_CLICK = 106;
	
	private IMInterstitial interstitial;
	private AdInterstitialListener adInterstitialListener;
	
	private boolean initialized = false;

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	if (action.equals("showAd")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                	showAd(callbackContext);
                }
            });
            return true;
        }
        return false;
    }

    private void showAd(CallbackContext callbackContext) {
        Log.d("InMobi", "InMobi plugin called");
        if (!this.initialized)
		{
			InMobi.initialize(cordova.getActivity(), "Insert InMobi property ID here");
			interstitial = new IMInterstitial(cordova.getActivity(), "Insert InMobi property ID here");
			
			adInterstitialListener = new AdInterstitialListener();
			interstitial.setIMInterstitialListener(adInterstitialListener);
			
			this.initialized = true;
		}
		
		
		interstitial.loadInterstitial();
    }
    
    private Handler handler = new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case AD_REQUEST_SUCCEEDED:
				Log.d("InMobi", "InMobi plugin ready");
				onShowAd(null);
				break;
			case AD_REQUEST_FAILED:
				Log.d("InMobi", "InMobi plugin failed");
				break;
			case ON_SHOW_MODAL_AD:
				break;
			case ON_DISMISS_MODAL_AD:
				break;
			case ON_LEAVE_APP:
				break;
			case ON_CLICK :
				break;								
			}
			super.handleMessage(msg);
		}		
	};
	
	public void onShowAd(View view){
		if(interstitial != null) 
			interstitial.show();
	}
    
    class AdInterstitialListener implements  IMInterstitialListener {

		@Override
		public void onLeaveApplication(IMInterstitial arg0) {
			handler.sendEmptyMessage(ON_LEAVE_APP);			
		}
		@Override
		public void onDismissInterstitialScreen(IMInterstitial arg0) {
			handler.sendEmptyMessage(ON_DISMISS_MODAL_AD);
		}

		@Override
		public void onInterstitialFailed(IMInterstitial arg0, IMErrorCode eCode) {
			Message msg = handler.obtainMessage(AD_REQUEST_FAILED);
			msg.obj = eCode;
			handler.sendMessage(msg);	
		}

		@Override
		public void onInterstitialInteraction(IMInterstitial arg0,
				Map<String, String> arg1) {
			// no-op
		}

		@Override
		public void onInterstitialLoaded(IMInterstitial arg0) {
			handler.sendEmptyMessage(AD_REQUEST_SUCCEEDED);	
		}

		@Override
		public void onShowInterstitialScreen(IMInterstitial arg0) {
			handler.sendEmptyMessage(ON_SHOW_MODAL_AD);	
		}
	};
}