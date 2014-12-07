package com.example.circularimageview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TouchAdapter extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;
	private FlipImageView mFlipImageView;
	private FlipImageView lastFlippedImageView;
	private Typeface font;
	
    public TouchAdapter(Context c,String[] web,int[] Imageid ) {
          mContext = c;
          this.Imageid = Imageid;
          this.web = web;
          String typeFace = "fonts/sinkinsans100thin.otf";
  		  font = Typeface.createFromAsset(mContext.getAssets(), typeFace);
     }
    
    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return web.length;
    }
    @Override
    public Object getItem(int position) {
      // TODO Auto-generated method stub
      return null;
    }
    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      View grid;
      LayoutInflater inflater = (LayoutInflater) mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setTypeface(font, 1);
            mFlipImageView = (FlipImageView)grid.findViewById(R.id.row_icon);
            textView.setText(web[position]);
            mFlipImageView.setDrawable(mContext.getResources().getDrawable(Imageid[position]));
    		mFlipImageView.setFlippedDrawable(mContext.getResources().getDrawable(R.drawable.images));
            mFlipImageView.setImageResource(Imageid[position]);
            
            mFlipImageView.setOnFlipListener(new FlipImageView.OnFlipListener() {
				
				@Override
				public void onFlipStart(FlipImageView view) {
					if(lastFlippedImageView != null){
							lastFlippedImageView.performClick();
					}
					 mFlipImageView.setInterpolator(new AccelerateDecelerateInterpolator());
				     mFlipImageView.setDuration(1200);
				     mFlipImageView.setRotationXEnabled(false);
				     mFlipImageView.setRotationYEnabled(false);
				     mFlipImageView.setRotationZEnabled(false);
				     mFlipImageView.setRotationReversed(false);	
				}
				
				@Override
				public void onFlipEnd(FlipImageView view) {
					// TODO Auto-generated method stub
					 lastFlippedImageView = mFlipImageView;
				}
				
				@Override
				public void onClick(FlipImageView view) {
					// TODO Auto-generated method stub
					
				}
			});
          } else {
            grid = (View) convertView;
          }
      return grid;
    }
}
