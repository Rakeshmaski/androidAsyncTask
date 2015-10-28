package com.qurater.csr.rest;

import org.json.JSONException;
import org.json.JSONObject;

import com.qurater.csr.activity.R;
import com.qurater.csr.api.URLMap;
import com.qurater.csr.api.User;
import com.qurater.csr.interfaces.ILoginUser;

public class LoginApi implements IDataSink {
	
	private ILoginUser activity;
	/**
	 * Constructor
	 */
	public LoginApi(ILoginUser activity) {
		this.activity = activity;
	}
	
	/**
	 * Login
	 */
	public void doLogin(String editTextUserName, String editTextPassword) {
		String url = URLMap.getUrl("login_url");
		url = url.replace("{email_id}", editTextUserName).replace("{password}", editTextPassword).replace("{ot}", "auto");
		System.out.println("in do login method:"+url);
		RemoteDataFetcher.login(url, editTextUserName, editTextPassword, activity.getApplicationContext(), this);
	}

	@Override
	public void receive(String response) {
		System.out.println("response is:"+response);
		try {
		
			JSONObject jResponse = new JSONObject(response);
			/*String kind = jResponse.getString(QuraterConstants.KIND);
			if (QuraterConstants.ME.equals(kind)) {
				LoggedInUserStore.storeLoggedInUser(activity.getApplicationContext(), jResponse);*/ 
				JSONObject data = jResponse.getJSONObject("user");				
				activity.onLogin(User.fromJson(data));
			/*} else {
				activity.onLoginFailure(activity.getApplicationContext().getResources().getString(R.string.title_activity_login));
			}*/
			
		} catch (JSONException e) {
			activity.onLoginFailure(activity.getApplicationContext().getResources().getString(R.string.title_activity_login));
		}
	}

	@Override
	public void error(Throwable e, String response) {
		
		activity.onLoginFailure(activity.getApplicationContext().getResources().getString(R.string.title_activity_login));
	}
}