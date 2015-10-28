package com.qurater.csr.rest;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
	ImageView imgView;

	

	public DownloadImage(ImageView imgView) {
		super();
		this.imgView = imgView;
	}
	@Override
	protected Bitmap doInBackground(String... urls) {
		Bitmap Icon=null;
		String urlDisplay=urls[0];
		try{
			InputStream in=new java.net.URL(urlDisplay).openStream();
			Icon=BitmapFactory.decodeStream(in);
		
			
		}catch(Exception e){
			Log.e("Error",e.getMessage());
			e.printStackTrace();
			
		}
		
		return Icon;
	}
	protected void onPostExecute(Bitmap result){
		imgView.setImageBitmap(result);
	}
}
