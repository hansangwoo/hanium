package com.example.reallockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RestartReceiver extends BroadcastReceiver{

	static public final String ACTION_RESTART_SERVICE = "RestartReceiver.restart";    // °ªÀº ¸¾´ë·Î
	
	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equals(ACTION_RESTART_SERVICE)){
			Intent i = new Intent(context, ScreenService.class);
			context.startService(i);
		}		
	}	
}