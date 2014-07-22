package com.example.reallockscreen;



import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.SystemClock;

public class ScreenService extends Service {
	
	private ScreenReceiver mReceiver = null;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	public void registerRestartAlarm(boolean isOn){
		Intent intent = new Intent(ScreenService.this, RestartReceiver.class);
		intent.setAction(RestartReceiver.ACTION_RESTART_SERVICE);
		PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
				
		AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
		if(isOn){
		am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 1000, 10000, sender);
		}else{
		am.cancel(sender);
		}
		}
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		mReceiver = new ScreenReceiver();		
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
		registerReceiver(mReceiver, filter);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		super.onStartCommand(intent, flags, startId);
		startForeground(1, new Notification());
		if(intent != null){
			if(intent.getAction()==null){
				if(mReceiver==null){
					mReceiver = new ScreenReceiver();					
					IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
					registerReceiver(mReceiver, filter);
				}
			}
		}
		return START_REDELIVER_INTENT;
	}
	
	@Override
	public void onDestroy(){		 	
		super.onDestroy();
		mReceiver.reenableKeyguard();
		if(mReceiver != null){
			unregisterReceiver(mReceiver);
		}
	}
}
