package com.example.profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.circularimageview.CircularImageView;
import com.example.circularimageview.R;

public class MainProfileActivity extends Activity {
	
	private CircularImageView mProfileImageView;
	private TextView mNamelabel;
	private TextView mStatusLabel;
	
	public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_2));
        setContentView(R.layout.profile);
        String typeFace = "fonts/sinkinsans100thin.otf";
		Typeface font = Typeface.createFromAsset(getAssets(), typeFace);
		
		mNamelabel = (TextView) findViewById(R.id.nametextView1);
		mNamelabel.setTypeface(font,1);
		mNamelabel.setText("#Header Singh");
		mStatusLabel = (TextView) findViewById(R.id.statustextView2);
		mStatusLabel.setTypeface(font,1);
		mStatusLabel.setText("Hadu chacha ke bade bade chuchu");
        mProfileImageView = (CircularImageView) findViewById(R.id.profileimageView1);
        mProfileImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainProfileActivity.this, ProfileActivity.class);
				startActivity(i);
			}
		});
	}

}
