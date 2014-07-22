package com.example.reallockscreen;



import android.app.Activity;
import android.app.Fragment.SavedState;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
public class ConfigActivity extends Activity{

private Button onBtn, offBtn, OptionBtn, backBtn, phonenumberBtn;
private ImageView on_unselect, on_click,on ,off_unselect, off_click, off;
private EditText phonenumberEdit;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
	    setContentView(R.layout.lockscreen);
		
	    onBtn= (Button)findViewById(R.id.button1); 
	    offBtn= (Button)findViewById(R.id.button2); 
	    OptionBtn = (Button)findViewById(R.id.button3); 
	    
      onBtn.setOnClickListener(new OnClickListener(){
@Override
	    public void onClick(View v) {		
Intent intent = new Intent(ConfigActivity.this, ScreenService.class);
startService(intent);	
onRestart();
Toast.makeText(ConfigActivity.this, "lock On", Toast.LENGTH_SHORT).show();

}
});
      offBtn.setOnClickListener(new OnClickListener(){
@Override
	    public void onClick(View v) {		
Intent intent = new Intent(ConfigActivity.this, ScreenService.class);
stopService(intent);
finish();
}
});
      OptionBtn.setOnClickListener(new OnClickListener(){
    	  @Override
    	  
    	 
    	  	    public void onClick(View v) {		
    		  setContentView(R.layout.optionlayout);
    		  backBtn= (Button)findViewById(R.id.button1);
    		  phonenumberBtn= (Button)findViewById(R.id.button2);
    		  on_unselect = (ImageView)findViewById(R.id.imageView1);
    		  on = (ImageView)findViewById(R.id.imageView2);
    		  on_click = (ImageView)findViewById(R.id.imageView3);
    		  off_unselect = (ImageView)findViewById(R.id.imageView4);
    		  off = (ImageView)findViewById(R.id.imageView5);
    		  off_click = (ImageView)findViewById(R.id.imageView6);
    		  
    		  on_click.setClickable(false);
    		  on.setClickable(false);
    		  off_click.setClickable(false);
    		  off.setClickable(false);
    		  
    		on_unselect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					on.setVisibility(View.INVISIBLE);
					 on_unselect.setVisibility(View.INVISIBLE);
					 on_click.setVisibility(View.VISIBLE);
					 on_click.setClickable(true);
					 on_unselect.setClickable(false);
					 off.setVisibility(View.VISIBLE);
					 off.setClickable(true);
					 off_unselect.setVisibility(View.INVISIBLE);
					 
					 off.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							on_click.setVisibility(View.INVISIBLE);
							on.setVisibility(View.VISIBLE);
							on_click.setClickable(false);
							on.setClickable(true);
							 off.setVisibility(View.INVISIBLE);
							 off.setClickable(false);
							 off_click.setVisibility(View.VISIBLE);
							 off_click.setClickable(true);
							 
							 on.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									on_click.setVisibility(View.VISIBLE);
									on.setVisibility(View.INVISIBLE);
									on_click.setClickable(true);
									on.setClickable(false);
									 off.setVisibility(View.VISIBLE);
									 off.setClickable(true);
									 off_click.setVisibility(View.INVISIBLE);
									 off_click.setClickable(false);
									
								}
							});
							 
							 
						}
					});
					 
					 
					 
					 
				}	
			});
    		off_unselect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					off.setVisibility(View.INVISIBLE);
					 off_unselect.setVisibility(View.INVISIBLE);
					 off_click.setVisibility(View.VISIBLE);
					 off_click.setClickable(true);
					 off_unselect.setClickable(false);
					 on_unselect.setVisibility(View.INVISIBLE);
					 on.setVisibility(View.VISIBLE);
					 on_unselect.setClickable(false);
					 on.setClickable(true);
					 
					 
					 on.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							off_click.setVisibility(View.INVISIBLE);
							off_click.setClickable(false);
							off.setVisibility(View.VISIBLE);
							off.setClickable(true);
							on.setVisibility(View.INVISIBLE);
							on.setClickable(false);
							on_click.setVisibility(View.VISIBLE);
							on_click.setClickable(true);
							
							off.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									off.setVisibility(View.INVISIBLE);
									off.setClickable(false);
									off_click.setVisibility(View.VISIBLE);
									off_click.setClickable(true);
									on_click.setVisibility(View.INVISIBLE);
									on_click.setClickable(false);
									on.setVisibility(View.VISIBLE);
									on.setClickable(true);
									
									
									
								}
							});
							
							
							
						}
					});
					 
					 
					 
					 
				}
			});
    		  
    		
    		
    		
    		
    		backBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent intent = new Intent(ConfigActivity.this, ConfigActivity.class);
					startActivity(intent);
					finish();
				}
			});
    		
        phonenumberBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
				phonenumberEdit = (EditText)findViewById(R.id.editText1);
				final String al1 = phonenumberEdit.getText().toString();
				Toast.makeText(ConfigActivity.this, "입력하신 번호"+al1+"가 긴급통화 번호로 지정 되었습니다.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(ConfigActivity.this, LockScreenActivity.class);
				intent.putExtra("TEXT", al1);
				startActivity(intent);
				
				}
			});
    		
    		
    		
    		
    		
    		
    	  }
    	  
    	  
    
    	  
    	  
    	  
    	  
    	  
    	  });
      
      
}
}