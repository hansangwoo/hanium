package com.example.reallockscreen;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class LockScreenActivity extends Activity{
private ImageView playstore, phone, music ,messaging,kakaotalk,gmail,camera;
private RelativeLayout mview;

@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);

setContentView(R.layout.reallay);
final String phonenumber;
playstore = (ImageView)findViewById(R.id.imageView1); 
phone = (ImageView)findViewById(R.id.imageView2); 
music = (ImageView)findViewById(R.id.imageView3); 
messaging = (ImageView)findViewById(R.id.imageView4); 
kakaotalk = (ImageView)findViewById(R.id.imageView5); 
gmail = (ImageView)findViewById(R.id.imageView6); 
camera = (ImageView)findViewById(R.id.imageView7); 

mview=(RelativeLayout)findViewById(R.layout.reallay);
getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED 
| WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

Bundle intent = getIntent().getExtras();



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

phone.setOnClickListener(new OnClickListener(){
	@Override
    public void onClick(View v) {	
		
	
		Intent intent = getIntent();
        String str1;
         str1= intent.getExtras().getString("TEXT");
		
		
        Intent intent2 = new Intent (Intent.ACTION_CALL,Uri.parse("tel:"+str1));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
        startActivity(intent2);
	
	}

	
});





}




}