package com.qurater.csr.interfaces;

import java.util.List;

import android.content.Context;

import com.qurater.csr.api.BaseRecord;

public interface IBaseRecordConsumer {
	
public void onTicketsLoadFailure(String reason);
	
	/**
	 * Application Context
	 */
	public Context getApplicationContext();

	void onBaseRecordLoadSuccess(List<BaseRecord> baseRecords);

}
