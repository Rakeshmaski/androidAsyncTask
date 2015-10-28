package com.qurater.csr.rest;

import com.qurater.csr.api.URLMap;
import com.qurater.csr.interfaces.IAddNoteDetail;

public class SaveTicketDetailApi implements IDataSink {
	private IAddNoteDetail activity;
	public SaveTicketDetailApi(){
		
	}
	public SaveTicketDetailApi(IAddNoteDetail activity){
		super();
		this.activity=activity;
	}
	
	public void getTickets(String bId,String note) {
		String url = URLMap.getsaveNoteUrl("savenote_url");
		url = url.replace("{note}", note).replace("{id}", bId);
		System.out.println("The Url is:" + url);
		RemoteDataFetcher.put(url, activity.getApplicationContext(), this);
	}
	

	@Override
	public void receive(String response) {
		try{
			System.out.println("In SaveTicketDetailApi : receive method");
			System.err.println(response);
			System.out.println("note saved sucessfully");
		}
		catch(Exception e){
			
		}
	}
	@Override
	public void error(Throwable e, String response) {
		System.out.println("failed to save the note");
		
	}

}
