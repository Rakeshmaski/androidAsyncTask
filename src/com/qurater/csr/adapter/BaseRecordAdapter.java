package com.qurater.csr.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qurater.csr.activity.R;
import com.qurater.csr.activity.TicketDetailActivity;
import com.qurater.csr.api.BaseRecord;
import com.qurater.csr.api.Font;
import com.qurater.csr.rest.DownloadImage;
import com.squareup.picasso.Picasso;

public class BaseRecordAdapter extends BaseAdapter {
	protected List<BaseRecord> baseRecords;
	protected TicketDetailActivity activity;

	public BaseRecordAdapter(TicketDetailActivity activity) {
		this.activity = activity;
	}

	@Override
	public int getCount() {
		System.out.println("In BaseRecordAdapter getCount");
		return (baseRecords != null) ? baseRecords.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		System.out.println("In BaseRecordAdapter getItem");
		return (baseRecords != null) ? baseRecords.get(position) : null;
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
			layout = getActivity().getLayoutInflater().inflate(R.layout.one_baserecord, parent, false);
		} else {
			layout = (RelativeLayout) convertView;
		}

		final BaseRecord baseRecord = baseRecords.get(position);

		Typeface typefaceDroidSerifBoldItalic = Font.getFont(getActivity().getApplicationContext(),
				"DroidSerif-BoldItalic.ttf");

		layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		TextView tv = (TextView) layout.findViewById(R.id.fromUserName);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String fromUserName = baseRecord.getFromUserName();
		tv.setText("From-Uname=" + " " + fromUserName);

		tv = (TextView) layout.findViewById(R.id.fromUserId);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String fromUserId = baseRecord.getFromUserId();
		tv.setText("FromUserId=" + fromUserId);

		tv = (TextView) layout.findViewById(R.id.sentiment);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.ITALIC);
		String sentiment = baseRecord.getSentiment();
		tv.setText("Sentiment=" + sentiment);

		tv = (TextView) layout.findViewById(R.id.id);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.BOLD_ITALIC);
		String id = baseRecord.getId();
		tv.setText("id=" + id);

		tv = (TextView) layout.findViewById(R.id.category1);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.BOLD_ITALIC);
		String category1 = baseRecord.getCategory1();
		tv.setText(category1);

		tv = (TextView) layout.findViewById(R.id.message);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.BOLD_ITALIC);
		String message = baseRecord.getMessage();
		tv.setText("Message=" + message);

		ImageView imgView = (ImageView) layout.findViewById(R.id.icon_fb);
		imgView.setImageResource(R.drawable.fbimg);

		tv = (TextView) layout.findViewById(R.id.organization);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.BOLD_ITALIC);
		String organization = baseRecord.getFacebookPosts().getOrganization();
		tv.setText(organization);

		tv = (TextView) layout.findViewById(R.id.fb_message);
		tv.setTypeface(typefaceDroidSerifBoldItalic, Typeface.BOLD_ITALIC);
		String fb_message = baseRecord.getFacebookPosts().getMessage();
		tv.setText(fb_message);

		String imgURL = baseRecord.getFacebookPosts().getIcon();
		ImageView imageView = (ImageView) layout.findViewById(R.id.icon_attachment);
		// new DownloadImage(imageView).execute(imgURL);
		Picasso.with(this.activity).load(imgURL).resize(200, 400).into(imageView);

		return layout;
	}

	public void clear() {
		baseRecords.clear();
		notifyDataSetChanged();
	}

	public void update(List<BaseRecord> b) {
		System.out.println("In BaseRecordAdapter : update method");
		b = (b == null) ? new ArrayList<BaseRecord>() : b;
		if (this.baseRecords != null) {
			System.out.println("BaseRecord not null");
			this.baseRecords.addAll(b);
		} else {
			System.out.println("BaseRecord null");
			this.baseRecords = b;
		}
		notifyDataSetChanged();

	}

}
