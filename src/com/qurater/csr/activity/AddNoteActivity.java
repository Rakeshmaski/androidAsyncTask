package com.qurater.csr.activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.qurater.csr.api.URLMap;
import com.qurater.csr.interfaces.IAddNoteDetail;

public class AddNoteActivity extends Activity implements IAddNoteDetail {

	protected String subActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ticket_save);

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

	public void saveNote(View view)	 {
		EditText et = (EditText) findViewById(R.id.editText);
		String note = et.getText().toString();
		System.out.println(note);
	
		Bundle extras = getIntent().getExtras();
		String bId = this.subActivity = (extras != null) ? (extras.getString("com.qurater.csr.ticket.id")) : null;
		System.out.println(bId);

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		//nameValuePairs.add(new BasicNameValuePair("", bId));
		nameValuePairs.add(new BasicNameValuePair("note", note));
		System.out.println("NameValuePair Note="+note);

		HttpClient httpClient = new DefaultHttpClient();
		String url = URLMap.getsaveNoteUrl("savenote_url");
		url = url.replace("{id}", bId);
		System.out.println("Note url="+url);
		HttpPost httpPost = new HttpPost(url);

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httpClient.execute(httpPost);
			Toast.makeText(this, "Post saved sucessflly:" , Toast.LENGTH_SHORT).show();

		} catch (UnsupportedEncodingException e) {
			System.out.println("1.caught unser saveTicketDetailActivity");
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			System.out.println("2.caught unser saveTicketDetailActivity");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("3.caught unser saveTicketDetailActivity");
			e.printStackTrace();
		}
	}

	@Override
	public void onSaveTicketDetailLoadFailure(String reason) {
		System.out.println("in saveTicketDetailActivity:onSaveTicketDetailLoadFailure");
	}

	@Override
	public void onSaveTicketDetailLoadSuccess() {
		System.out.println("in saveTicketDetailActivity:onSaveTicketDetailLoadFailure");

	}

}
