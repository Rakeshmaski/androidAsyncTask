package com.qurater.csr.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qurater.csr.activity.R;
import com.qurater.csr.activity.TicketDetailActivity;
import com.qurater.csr.api.Font;
import com.qurater.csr.api.History;

public class HistoryAdapter extends BaseAdapter {
	protected List<History> historys;
	protected TicketDetailActivity activity;

	public HistoryAdapter(TicketDetailActivity activity) {
		this.activity = activity;
	}

	@Override
	public int getCount() {
		System.out.println("In HistoryAdapter getCount");
		return (historys != null) ? historys.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return position;
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
			layout = getActivity().getLayoutInflater().inflate(R.layout.one_history, parent, false);
		} else {
			layout = (RelativeLayout) convertView;
		}

		final History history = historys.get(position);

		Typeface typefaceDroidSerifBoldItalic = Font.getFont(getActivity().getApplicationContext(),
				"DroidSerif-BoldItalic.ttf");

		layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		TextView tv = (TextView) layout.findViewById(R.id.ticketEventType);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String ticketEventType = history.getTicketEventType();
		tv.setText(ticketEventType + "" + "=Ticket-Event-Type");

		tv = (TextView) layout.findViewById(R.id.assignedTo);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		long assignedTo = history.getAssignedTo();
		tv.setText(assignedTo + "" + "=Assigned-To");
		
		tv = (TextView) layout.findViewById(R.id.reason);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String reason=history.getReason();
		tv.setText(reason + "" + "=reason");
		
		tv = (TextView) layout.findViewById(R.id.updatedByRep);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String updatedByRep=history.getUpdatedByRep();
		tv.setText(updatedByRep + "" + "=updatedByRep");
		
		

		return layout;
	}

	public void clear() {
		historys.clear();
		notifyDataSetChanged();
	}

	public void update(List<History> h) {
		System.out.println("In HistoryAdapter : update method");
		h = (h == null) ? new ArrayList<History>() : h;
		if (this.historys != null) {
			System.out.println("history not null");
			this.historys.addAll(h);
		} else {
			System.out.println("history null");
			this.historys = h;
		}
		notifyDataSetChanged();

	}

}
