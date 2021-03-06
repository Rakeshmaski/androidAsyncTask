package com.qurater.csr.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.qurater.csr.activity.R;
import com.qurater.csr.api.History;
import com.qurater.csr.api.URLMap;
import com.qurater.csr.interfaces.IHistoryConsumer;

public class HistoryApi implements IDataSink {
	private IHistoryConsumer activity;

	public HistoryApi(IHistoryConsumer activity) {
		super();
		this.activity = activity;
	}

	public HistoryApi() {
	}

	public void getTickets(String id) {
		System.out.println("History : id :" + id);
		String url = URLMap.getHistoryUrl("history_url");
		url = url.replace("{id}", id);
		System.out.println("The Url is:" + url);
		RemoteDataFetcher.get(url, activity.getApplicationContext(), this);
	}

	@Override
	public void receive(String response) {
		try {
			System.out.println("In HistoryApi : receive method");
			System.err.println(response);

			List<History> historys = new ArrayList<History>();
			JSONObject jbaseRecords = new JSONObject(response).getJSONObject("ticket");
			try {
				if (jbaseRecords.isNull("history")) {
					System.out.println("history is Null");
				} else {
					JSONArray history = jbaseRecords.getJSONArray("history");
					for (int i = 0; i < history.length(); i++) {
						JSONObject his = history.getJSONObject(i);
						System.out.println("history not null");
						historys.add(History.fromJson(his));
					}
				}

			} catch (Exception e) {
			}

			activity.onHistoryLoadSuccess(historys);

		}

		catch (Exception e) {
			System.out.println("HistoryApi : TicketLoadFailure");
			activity.onTicketsLoadFailure(activity.getApplicationContext().getResources()
					.getString(R.string.title_activity_ticket_list));
		}

	}

	@Override
	public void error(Throwable e, String response) {

	}

}
