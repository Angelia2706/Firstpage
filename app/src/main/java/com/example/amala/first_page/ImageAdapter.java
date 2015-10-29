package com.example.amala.first_page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by amala on 22/10/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter (Context c) {
        mContext = c;
    }
    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position,View convertView,ViewGroup parent){
        int height;
        int width;
        ImageView img = new ImageView(mContext);
        img.setImageResource(mThumbIds[position]);
        //img.setMaxHeight(200);
        //img.setMaxWidth(200);
        height= parent.getHeight();
        width = parent.getWidth();
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setPadding(8,8,8,8);
        img.setLayoutParams(new GridView.LayoutParams(width/3 , height/3));
        //img.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return img;
        //ImageButton imb = new ImageButton(mContext);
        //imb.setImageResource(mThumbIds[position]);

        //return  imb;

    }

    public int getCount()
    {
        return mThumbIds.length;
    }

    private Integer[] mThumbIds = {
            R.drawable.bike,
            R.drawable.car,
            R.drawable.bus,
            R.drawable.cycle,
            R.drawable.mini_bus,
            R.drawable.mini_lorry,
            R.drawable.handcart,
            R.drawable.truck,
            R.drawable.auto
    };
}
