package com.qurater.csr.activity;

import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qurater.csr.adapter.TicketAdapter;
import com.qurater.csr.api.Font;
import com.qurater.csr.api.Ticket;
import com.qurater.csr.interfaces.ITicketConsumer;
import com.qurater.csr.rest.TicketsApi;

public class TicketListActivity extends Activity implements ITicketConsumer {
	protected TicketAdapter adapter;
	ProgressBar progressBar;
	TextView content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ticket);
		progressBar=(ProgressBar)findViewById(R.id.ProgressBar);
		
		
		
		ListView tickets = (ListView) findViewById(R.id.tickets);
		
		Typeface typefaceLatoBold = Font.getFont(getApplicationContext(), "Lato-Bold.ttf");
		TextView tvTitle = (TextView) findViewById(R.id.title);
		tvTitle.setTypeface(typefaceLatoBold);
		tvTitle.setText(getResources().getString(R.string.my_tickets));

		adapter = new TicketAdapter(this);
		tickets.setAdapter(adapter);
		TicketsApi api = new TicketsApi(this);
		api.getTickets();
		
	}
	
	@Override
	public void onTicketsLoadSuccess(List<Ticket> tickets) {
		findViewById(R.id.ProgressBar).setVisibility(View.GONE);
		adapter.update(tickets);

	}

	@Override
	public void onTicketsLoadFailure(String reason) {
		findViewById(R.id.ProgressBar).setVisibility(View.VISIBLE);
	}

}
