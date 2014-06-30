package com.example.eslamimbooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		 Button button = (Button) findViewById(R.id.kutuphana);
		 Button aphana = (Button) findViewById(R.id.aphana);
	        // Capture button clicks
	        button.setOnClickListener(new OnClickListener() {
	            public void onClick(View arg0) {
	 
	                // Start NewActivity.class
	                Intent myIntent = new Intent(MainActivity.this,
	                        kutuphana.class);
	                startActivity(myIntent);
	            }
	        });
	        aphana.setOnClickListener(new OnClickListener() {
	            public void onClick(View arg0) {
	 
	                // Start NewActivity.class
	                Intent myIntent = new Intent(MainActivity.this,
	                        aphana.class);
	                startActivity(myIntent);
	            }
	        });
	}



}
