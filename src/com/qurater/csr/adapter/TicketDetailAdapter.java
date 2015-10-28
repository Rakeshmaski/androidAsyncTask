package com.qurater.csr.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qurater.csr.activity.AddNoteActivity;
import com.qurater.csr.activity.R;
import com.qurater.csr.activity.TicketDetailActivity;
import com.qurater.csr.api.Font;
import com.qurater.csr.api.Ticket;

public class TicketDetailAdapter extends BaseAdapter {
	protected List<Ticket> tickets;
	protected TicketDetailActivity activity;

	public TicketDetailAdapter(TicketDetailActivity activity) {
		super();
		this.activity = activity;
	}

	@Override
	public int getCount() {
		System.out.println("in TicketDetailAdapter getCount");
		return (tickets != null) ? tickets.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		System.out.println("in TicketDetailAdapter getPosition");
		return (tickets != null) ? tickets.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public Activity getActivity() {
		return this.activity;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View layout;
		if (convertView == null) {
			layout = getActivity().getLayoutInflater().inflate(R.layout.one_ticketdetail, parent, false);
		} else {
			layout = (RelativeLayout) convertView;
		}
		final Ticket ticket = tickets.get(position);
		Typeface typefaceDroidSerifBoldItalic = Font.getFont(getActivity().getApplicationContext(),
				"DroidSerif-BoldItalic.ttf");

		layout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Activity activity = getActivity();
				Intent intent = new Intent(getActivity(), AddNoteActivity.class);
				intent.putExtra("com.qurater.csr.ticket.id", ticket.getId());
				System.out.println("Adn=" + ticket.getId());
				getActivity().startActivity(intent);
				activity.overridePendingTransition(R.anim.slide_left_detail, R.anim.stay_in_place_detail);

			}

		});

		TextView tv = (TextView) layout.findViewById(R.id.fromUser);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String fromUser = ticket.getFromUser();
		tv.setText("From-User=" + " " + fromUser);

		tv = (TextView) layout.findViewById(R.id.priority);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String priority = ticket.getPriority();
		tv.setText("Priority="+" "+priority);

		tv = (TextView) layout.findViewById(R.id.ticketType);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String ticketType = ticket.getTicketType();
		tv.setText("Ticket-type="+" "+ticketType);

		tv = (TextView) layout.findViewById(R.id.category1);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String category1 = ticket.getCategory1();
		tv.setText("Category1="+" "+category1);

		tv = (TextView) layout.findViewById(R.id.category2);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String category2 = ticket.getCategory2();
		tv.setText("Category2="+" "+category2);

		tv = (TextView) layout.findViewById(R.id.category3);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String category3 = ticket.getCategory3();
		tv.setText("Category3="+" "+category3);

		tv = (TextView) layout.findViewById(R.id.category4);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String category4 = ticket.getCategory4();
		tv.setText("Category4="+" "+category4);

		tv = (TextView) layout.findViewById(R.id.sentiment);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		long sentiment = ticket.getSentiment();
		tv.setText("Sentiment="+" "+sentiment);

		tv = (TextView) layout.findViewById(R.id.origId);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		long origId = ticket.getOrigId();
		tv.setText("OridId="+" "+origId);

		tv = (TextView) layout.findViewById(R.id.ticketText);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String text = ticket.getText();
		tv.setText(text);

		return layout;

	}

	public void clear() {
		tickets.clear();
		notifyDataSetChanged();
	}

	public void update(List<Ticket> t) {
		System.out.println("In TicketDetailAdapter : update method");
		t = (t == null) ? new ArrayList<Ticket>() : t;
		if (this.tickets != null) {
			System.out.println("TicketDetail not null");
			this.tickets.addAll(t);
		} else {
			System.out.println("TicketDetail null");
			this.tickets = t;
		}
		notifyDataSetChanged();

	}

}
