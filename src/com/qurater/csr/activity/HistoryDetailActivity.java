/*package com.quratzer.csr.activity;

import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.qurater.csr.adapter.HistoryAdapter;
import com.qurater.csr.api.Font;
import com.qurater.csr.api.History;
import com.qurater.csr.interfaces.IHistoryConsumer;
import com.qurater.csr.rest.HistoryApi;

public class HistoryDetailActivity extends Activity implements IHistoryConsumer {
	protected HistoryAdapter adapter;
	TextView content;
	protected String subActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_history_detail);
		ListView history = (ListView) findViewById(R.id.history_details);

		
		Typeface typefaceLatoBold = Font.getFont(getApplicationContext(), "Lato-Bold.ttf");
		TextView tvTitle = (TextView) findViewById(R.id.title);
		tvTitle.setTypeface(typefaceLatoBold);
		tvTitle.setText(getResources().getString(R.string.my_history_details));
		Bundle extras = getIntent().getExtras();
		this.subActivity = (extras != null) ? (extras.getString("com.qurater.csr.project.id")) : null;
		adapter = new HistoryAdapter(this);
		history.setAdapter(adapter);
		HistoryApi api = new HistoryApi(this);
		api.getTickets(subActivity);
	}

	@Override
	public void onTicketsLoadFailure(String reason) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTicketsLoadSuccess(List<History> historys) {
		System.out.println("TicketDetailActivity:onTicketsLoadSuccess");
		adapter.update(historys);
	}
}
*/