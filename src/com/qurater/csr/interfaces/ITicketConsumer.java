package com.qurater.csr.interfaces;

import java.util.List;

import android.content.Context;

import com.qurater.csr.api.Ticket;

public interface ITicketConsumer {

	
	public void onTicketsLoadFailure(String reason);
	
	/**
	 * Application Context
	 */
	public Context getApplicationContext();

	void onTicketsLoadSuccess(List<Ticket> project);
}
