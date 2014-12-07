package com.example.circularimageview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	
	private EditText touchIdView;
	private EditText passwordView;
	private EditText cnfPasswordView;
	private Button registerButton;
	private TextView goToSignIn;
	
	private final String  PREFS_NAME = "magic_touch";
	private TextView signLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		String typeFace = "fonts/sinkinsans100thin.otf";
		Typeface font = Typeface.createFromAsset(getAssets(), typeFace);
		
		signLabel = (TextView) findViewById(R.id.signinlabel);
		signLabel.setTypeface(font,1);
		touchIdView = (EditText) findViewById(R.id.touchid);
		touchIdView.setTypeface(font,1);
		passwordView = (EditText) findViewById(R.id.password);
		passwordView.setTypeface(font,1);
		cnfPasswordView = (EditText) findViewById(R.id.cnfpassword);
		cnfPasswordView.setTypeface(font,1);
		registerButton = (Button) findViewById(R.id.register);
		registerButton.setTypeface(font,1);
		goToSignIn= (TextView) findViewById(R.id.opensignin);
		goToSignIn.setTypeface(font,1);
		registerButton.setOnClickListener(new RegisterButtonListener());
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME , Context.MODE_PRIVATE);
		if (settings.getString("registered", "").toString().equals("registered")) {
			if (settings.getString("logged", "").toString().equals("logged")) {
				Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}else{
				Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}
		
		goToSignIn.setOnClickListener(new GoToSignInPageListener());
	}
	
	public class RegisterButtonListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			//Here we will take care of users registration part
			
			//if user is registered successfully then modify shared prefs here
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString("registered", "registered");
			editor.commit();

		}
		
	}
	
	public class GoToSignInPageListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
			startActivity(intent);
		}
		
	}

}
