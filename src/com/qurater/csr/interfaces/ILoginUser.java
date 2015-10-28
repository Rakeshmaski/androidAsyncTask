package com.qurater.csr.interfaces;

import android.content.Context;
import android.os.Bundle;

import com.qurater.csr.api.User;

public interface ILoginUser {
	public void onLogin(User u);

	public void onLoginFailure(String reason);

	
	public Context getApplicationContext();

	void onActivityCreated(Bundle savedInstanceState);

	void finish();


}
