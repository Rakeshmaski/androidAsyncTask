package com.qurater.csr.activity;

import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.qurater.csr.adapter.BaseRecordAdapter;
import com.qurater.csr.adapter.HistoryAdapter;
import com.qurater.csr.adapter.TicketDetailAdapter;
import com.qurater.csr.api.BaseRecord;
import com.qurater.csr.api.Font;
import com.qurater.csr.api.History;
import com.qurater.csr.api.Ticket;
import com.qurater.csr.interfaces.IBaseRecordConsumer;
import com.qurater.csr.interfaces.IHistoryConsumer;
import com.qurater.csr.interfaces.ITicketDetailConsumer;
import com.qurater.csr.rest.BaseRecordsApi;
import com.qurater.csr.rest.HistoryApi;
import com.qurater.csr.rest.TicketDetailApi;

public class TicketDetailActivity extends Activity implements IBaseRecordConsumer, IHistoryConsumer,
		ITicketDetailConsumer {
	protected BaseRecordAdapter adapter;
	protected HistoryAdapter hAdapter;
	protected TicketDetailAdapter tAdapter;
	TextView content;
	protected String subActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_ticket_detail);

		ListView tickets = (ListView) findViewById(R.id.ticket_details);
		Typeface typefaceLatoBold = Font.getFont(getApplicationContext(), "Lato-Bold.ttf");
		TextView tvTitle = (TextView) findViewById(R.id.title);
		tvTitle.setTypeface(typefaceLatoBold);
		tvTitle.setText(getResources().getString(R.string.my_ticket_details));
		Bundle extr = getIntent().getExtras();
		this.subActivity = (extr != null) ? (extr.getString("com.qurater.csr.ticket.id")) : null;
		tAdapter = new TicketDetailAdapter(this);
		tickets.setAdapter(tAdapter);
		TicketDetailApi tapi=new TicketDetailApi(this);
		tapi.getTickets(subActivity);

		ListView baseRecords = (ListView) findViewById(R.id.baserecord_details);

		Bundle extras = getIntent().getExtras();
		String id=this.subActivity = (extras != null) ? (extras.getString("com.qurater.csr.ticket.id")) : null;
		System.out.println("TDId="+id);
		adapter = new BaseRecordAdapter(this);
		baseRecords.setAdapter(adapter);
		BaseRecordsApi api = new BaseRecordsApi(this);
		api.getTickets(subActivity);

		ListView historys = (ListView) findViewById(R.id.history_details);
		Bundle extra = getIntent().getExtras();
		this.subActivity = (extra != null) ? (extra.getString("com.qurater.csr.ticket.id")) : null;
		hAdapter = new HistoryAdapter(this);
		historys.setAdapter(hAdapter);
		HistoryApi hapi = new HistoryApi(this);
		hapi.getTickets(subActivity);

	}

	@Override
	public void onTicketsLoadFailure(String reason) {

	}

	@Override
	public void onBaseRecordLoadSuccess(List<BaseRecord> baseRecords) {
		System.out.println("TicketDetailActivity:onTicketsLoadSuccess");
		adapter.update(baseRecords);
	}

	@Override
	public void onHistoryLoadSuccess(List<History> historys) {
		System.out.println("onhistoryLoadSuccess");
		hAdapter.update(historys);

	}

	@Override
	public void onTicketDetailLoadSuccess(List<Ticket> tickets) {
		System.out.println("TicketDetailActivity:onTicketsLoadSuccess");
		tAdapter.update(tickets);
	}

}
