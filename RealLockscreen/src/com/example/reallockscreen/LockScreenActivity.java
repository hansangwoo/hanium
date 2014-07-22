package com.example.reallockscreen;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class LockScreenActivity extends Activity{
private ImageView playstore, phone, music ,messaging,kakaotalk,gmail,camera;
@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.reallay);
playstore = (ImageView)findViewById(R.id.imageView1); 
phone = (ImageView)findViewById(R.id.imageView2); 
music = (ImageView)findViewById(R.id.imageView3); 
messaging = (ImageView)findViewById(R.id.imageView4); 
kakaotalk = (ImageView)findViewById(R.id.imageView5); 
gmail = (ImageView)findViewById(R.id.imageView6); 
camera = (ImageView)findViewById(R.id.imageView7); 


getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED 
| WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);


playstore.setOnClickListener(new OnClickListener(){
	@Override
    public void onClick(View v) {	
		Toast.makeText(LockScreenActivity.this, "권한이 없는 사용자 입니다.", Toast.LENGTH_LONG).show();
		setContentView(R.layout.lockscreen2);
	}
	
	
	
	
});

kakaotalk.setOnClickListener(new OnClickListener(){
	@Override
    public void onClick(View v) {	
		Toast.makeText(LockScreenActivity.this, "잠금 해제가 완료되었습니다.", Toast.LENGTH_LONG).show();
		finish();
	}
	
	
	
	
});


}


}