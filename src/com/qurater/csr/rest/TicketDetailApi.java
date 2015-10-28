package com.qurater.csr.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.qurater.csr.activity.R;
import com.qurater.csr.api.Ticket;
import com.qurater.csr.api.URLMap;
import com.qurater.csr.interfaces.ITicketDetailConsumer;

public class TicketDetailApi implements IDataSink {
	private ITicketDetailConsumer activity;

	public TicketDetailApi() {
		super();
	}

	public TicketDetailApi(ITicketDetailConsumer activity) {
		super();
		this.activity = activity;
	}

	public void getTickets(String id) {
		System.out.println(" : id :" + id);
		String url = URLMap.getTicketsUrl("tickets_url");
		url = url.replace("{id}", id);
		System.out.println("The ticketdetail Url is:" + url);
		RemoteDataFetcher.get(url, activity.getApplicationContext(), this);
	}

	@Override
	public void receive(String response) {
		try {
			System.out.println("in TicketDetailApi receive method");
			System.err.println(response);

			List<Ticket> tickets = new ArrayList<Ticket>();
			JSONObject jTickets = new JSONObject(response).getJSONObject("ticket");
			try {
				if (jTickets.equals(null)) {
					System.out.println("ticket is Null");
				} else {
					tickets.add(Ticket.fromJson(jTickets));
				}

			} catch (Exception e) {

			}

			activity.onTicketDetailLoadSuccess(tickets);
		} catch (Exception e) {
			activity.onTicketsLoadFailure(activity.getApplicationContext().getResources()
					.getString(R.string.title_activity_ticket_list));
		}

	}

	@Override
	public void error(Throwable e, String response) {
		activity.onTicketsLoadFailure(activity.getApplicationContext().getResources()
				.getString(R.string.title_activity_ticket_list));

	}

}
