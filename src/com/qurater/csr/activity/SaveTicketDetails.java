package com.qurater.csr.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;

public class SaveTicketDetails extends Activity{

	protected String subActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ticket_save);
		
		Bundle extras = getIntent().getExtras();
		
		ImageView imageView = (ImageView) findViewById(R.id.saveticket);
		imageView.setImageResource(R.drawable.save);
		imageView.getLayoutParams().height = 85;
		imageView.getLayoutParams().width = 85;

		imageView = (ImageView) findViewById(R.id.addnote);
		imageView.setImageResource(R.drawable.addnotes);
		imageView.getLayoutParams().height = 85;
		imageView.getLayoutParams().width = 85;

		imageView = (ImageView) findViewById(R.id.delete);
		imageView.setImageResource(R.drawable.delete);
		imageView.getLayoutParams().height = 85;
		imageView.getLayoutParams().width = 85;
		
	}

	public void saveNote(View view) {
		EditText et = (EditText) findViewById(R.id.editText);
		String note = et.getText().toString();
		System.out.println(note);

	}

}
