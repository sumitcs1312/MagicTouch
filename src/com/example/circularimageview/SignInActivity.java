package com.example.circularimageview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends Activity {
	
	private EditText touchIdView;
	private EditText passwordView;
	private Button signInButton;
	private TextView errorText;
	private TextView registerText;
	private TextView forgotText;
	
	private final String  PREFS_NAME = "magic_touch";
	private TextView signInView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.signin);
		String typeFace = "fonts/sinkinsans100thin.otf";
		Typeface font = Typeface.createFromAsset(getAssets(), typeFace);
		
		signInView = (TextView) findViewById(R.id.signinlabel);
		signInView.setTypeface(font,1);
		touchIdView = (EditText) findViewById(R.id.signintouchid);
		touchIdView.setTypeface(font,1);
		passwordView = (EditText) findViewById(R.id.signinpassword);
		passwordView.setTypeface(font,1);
		signInButton = (Button) findViewById(R.id.signin);
		signInButton.setTypeface(font,1);
		errorText = (TextView) findViewById(R.id.error);
		errorText.setTypeface(font,1);
		registerText = (TextView) findViewById(R.id.registerlink);
		registerText.setTypeface(font,1);
		forgotText = (TextView) findViewById(R.id.forgot);
		forgotText.setTypeface(font,1);
		
		
		
		signInButton.setOnClickListener(new SignInButtonListener());
		
		registerText.setOnClickListener(new RegisterTextListener());
		forgotText.setOnClickListener(new ForgotTextListener());
		
		errorText.setVisibility(View.GONE);
		
		 /*
         * Check if we successfully logged in before. 
         * If we did, redirect to home page
         */
        SharedPreferences settings = getSharedPreferences(PREFS_NAME , Context.MODE_PRIVATE);
		if (settings.getString("logged", "").toString().equals("logged")) {
			Intent intent = new Intent(SignInActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	public class SignInButtonListener implements OnClickListener{

		private boolean signInFialed = false;

		@Override
		public void onClick(View arg0) {
			if(touchIdView.getText().toString().length() > 0 && passwordView.getText().toString().length() > 0 ) {
				if(touchIdView.getText().toString().equals("test") && passwordView.getText().toString().equals("test")) {
					/*
					 * So login information is correct, 
					 * we will save the Preference data
					 * and redirect to next class / home  
					 */
					if(signInFialed){
						errorText.setVisibility(View.VISIBLE);
					}else{
						SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
						SharedPreferences.Editor editor = settings.edit();
						editor.putString("logged", "logged");
						editor.commit();

						Intent intent = new Intent(SignInActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					}
					
					
				}
			}
		}
	}
		
		public class ForgotTextListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				
			}
		
		}
		public class RegisterTextListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		
		}

}
