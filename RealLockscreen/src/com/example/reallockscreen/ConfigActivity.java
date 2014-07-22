package com.example.reallockscreen;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class ConfigActivity extends Activity{

private Button onBtn, offBtn, OptionBtn;
	
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

    		  
    		  
    		  
    	  }
    	  });
      
      
}
}