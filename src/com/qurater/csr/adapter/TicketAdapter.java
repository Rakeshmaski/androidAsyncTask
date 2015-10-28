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

import com.qurater.csr.activity.R;
import com.qurater.csr.activity.TicketDetailActivity;
import com.qurater.csr.activity.TicketListActivity;
import com.qurater.csr.api.Font;
import com.qurater.csr.api.Ticket;

public class TicketAdapter extends BaseAdapter {
	protected List<Ticket> tickets;
	protected TicketListActivity activity;

	public TicketAdapter(TicketListActivity activity) {
		this.activity = activity;
	}

	@Override
	public int getCount() {
		return (tickets != null) ? tickets.size() : 0;
	}

	@Override
	public Object getItem(int position) {
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
			layout = getActivity().getLayoutInflater().inflate(R.layout.one_ticket, parent, false);
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
				Intent intent = new Intent(getActivity(), TicketDetailActivity.class);
				intent.putExtra("com.qurater.csr.ticket.id", ticket.getId());
				getActivity().startActivity(intent);
				activity.overridePendingTransition(R.anim.slide_left_detail, R.anim.stay_in_place_detail);
				
			}

		});

		TextView tv = (TextView) layout.findViewById(R.id.status);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String status = ticket.getStatus();
		tv.setText("STATUS :"+ " "+status);

		tv = (TextView) layout.findViewById(R.id.id);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String id = ticket.getId();
		tv.setText("Ticket Id:"+" "+id);

		/*tv = (TextView) layout.findViewById(R.id.update_date);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String updateDate = ticket.getUpdateDate();
		tv.setText(updateDate);*/

		tv = (TextView) layout.findViewById(R.id.create_date);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String createDate = ticket.getCreateDate();
		tv.setText("Create Date:"+" "+createDate);

		tv = (TextView) layout.findViewById(R.id.assignedto);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String assignedTo = ticket.getAssignedTo();
		tv.setText("Assigned to:"+" "+assignedTo);

		tv = (TextView) layout.findViewById(R.id.priority);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String priority = ticket.getPriority();
		tv.setText("Priority:"+" "+priority);
		
		
		tv = (TextView) layout.findViewById(R.id.ticketType);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String ticketType = ticket.getTicketType();
		tv.setText("Ticket Type:"+" "+ticketType);
		return layout;

	}

	public void clear() {
		tickets.clear();
		notifyDataSetChanged();
	}

	public void update(List<Ticket> p) {
		p = (p == null) ? new ArrayList<Ticket>() : p;
		if (this.tickets != null) {
			this.tickets.addAll(p);
		} else {
			this.tickets = p;
		}
		notifyDataSetChanged();
	}

}
