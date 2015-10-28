package com.qurater.csr.interfaces;

import android.content.Context;

public interface IAddNoteDetail {
	
public void onSaveTicketDetailLoadFailure(String reason);
	
	/**
	 * Application Context
	 */
	public Context getApplicationContext();

	void onSaveTicketDetailLoadSuccess();


}
