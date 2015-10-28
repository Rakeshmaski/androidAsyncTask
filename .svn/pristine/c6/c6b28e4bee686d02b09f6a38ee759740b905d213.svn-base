package com.qurater.csr.api;

import java.util.HashMap;
import java.util.Map;

public class URLMap {
	public static String QURATER_BASE_URL = "http://auto.quraterapps.com/a";
	public static String QURATER_AUTO_APP_URL="http://auto.quraterapps.com/a/rest/selfserve";
	public static String QURATER_TICKET_URL="http://auto.quraterapps.com/a/rest/ticket/";
	public static String QURATER_HISTORY_URL="http://auto.quraterapps.com/a/rest/ticket/";
	public static String QURATER_SAVENOTE_URL="http://auto.quraterapps.com/a/rest/csr/selfserve/ticket/note/";
	
	public static Map<String, String> m_urls = new HashMap<String, String>();
	static {
		m_urls.put("login_url", "/login_oodja_user.do?email={email_id}&password={password}&o={ot}");
		m_urls.put("projects_url", "/tickets?timespan_type=ONE_MONTH");
		m_urls.put("tickets_url", "{id}");
		m_urls.put("history_url", "{id}");
		m_urls.put("savenote_url", "{id}");
	}
	
	public static String getUrl(String key) {
		return QURATER_BASE_URL + m_urls.get(key);
	}
	
	public static String getAutoAppUrl(String key) {
		return QURATER_AUTO_APP_URL + m_urls.get(key);
	}
	public static String getTicketsUrl(String key){
		return QURATER_TICKET_URL + m_urls.get(key);
	}
	public static String getHistoryUrl(String key){
		return QURATER_HISTORY_URL + m_urls.get(key);
	}
	public static String getsaveNoteUrl(String key) {
		return QURATER_SAVENOTE_URL+m_urls.get(key);
		
	}

}
