package com.example.circularimageview;

import com.example.profile.MainProfileActivity;
import com.example.profile.ProfileActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
//implements FlipImageView.OnFlipListener{
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getItemId()==R.id.action_settings){
			//launch profile actiivity
			Intent i = new Intent(this, MainProfileActivity.class);
			startActivity(i);
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	//FlipImageView mFlipImageView;
	GridView grid;
	  String[] web = {
	      "Sarah",
	      "Jenny",
	      "Rose",
	      "Gabrial",
	      "Derek",
	      "Ping",
	      "Robert",
	      "Samir",
	      "Mia",
	      "Frida",
	      "Misty",
	      "George",
	      "Sandra",
	      "Smith",
	      "Samantha",
	      "Sarah",
	      "Jenny",
	      "Rose",
	      "Gabrial",
	      "Derek",
	      "Ping"
	  } ;
	  int[] imageId = {
	      R.drawable.image1,
	      R.drawable.image2,
	      R.drawable.image3,
	      R.drawable.image9,
	      R.drawable.image10,
	      R.drawable.image12,
	      R.drawable.image11,
	      R.drawable.image15,
	      R.drawable.image4,
	      R.drawable.image5,
	      R.drawable.image7,
	      R.drawable.image13,
	      R.drawable.image6,
	      R.drawable.image14,
	      R.drawable.image8,
	      R.drawable.image1,
	      R.drawable.image2,
	      R.drawable.image3,
	      R.drawable.image9,
	      R.drawable.image10,
	      R.drawable.image12
	  };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_2));
		TouchAdapter adapter = new TouchAdapter(MainActivity.this, web, imageId);
	    grid=(GridView)findViewById(R.id.grid);
	        grid.setAdapter(adapter);
	        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                @Override
	                public void onItemClick(AdapterView<?> parent, View view,
	                                        int position, long id) {
	                    Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                }
	            });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
