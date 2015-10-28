package com.qurater.csr.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.qurater.csr.interfaces.ISaveTicketDetail;
import com.qurater.csr.rest.SaveTicketDetailApi;

public class SaveTicketDetailActivity extends Activity implements ISaveTicketDetail {

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

	public void saveNote(View view) {
		EditText et = (EditText) findViewById(R.id.editText);
		String note = et.getText().toString();
		System.out.println(note);
		Bundle extras = getIntent().getExtras();
		String bId = this.subActivity = (extras != null) ? (extras.getString("com.qurater.csr.baseRecord.id")) : null;
		System.out.println(bId);
		SaveTicketDetailApi sApi=new SaveTicketDetailApi();
		sApi.getTickets(bId,note);
		//makePostRequest(bId, note);
	}

	/*private void makePostRequest(String bId,String note) {
		HttpClient httpClient=new DefaultHttpClient();
		String url=URLMap.getsaveNoteUrl("savenote_url");
		url = url.replace("{id}", bId).replace("{note}", note);
		HttpPost httpPost=new HttpPost(url);
	}*/

	public void onSaveTicketDetailLoadFailure(String reason) {
		System.out.println("in saveTicketDetailActivity:onSaveTicketDetailLoadFailure");
	}

	public void onSaveTicketDetailLoadSuccess() {
		System.out.println("in saveTicketDetailActivity:onSaveTicketDetailLoadFailure");

	}

}
