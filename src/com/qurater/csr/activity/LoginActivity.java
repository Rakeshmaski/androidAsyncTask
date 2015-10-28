package com.qurater.csr.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qurater.csr.api.User;
import com.qurater.csr.interfaces.ILoginUser;
import com.qurater.csr.rest.LoginApi;

/**
 * Login Activity
 * 
 * @author Rakesh Maski
 *
 */
public class LoginActivity extends Activity implements ILoginUser {
	protected ILoginUser activity;
	Button btnSignIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		final EditText editTextUserName = (EditText) findViewById(R.id.editTextUserNameToLogin);
		final EditText editTextPassword = (EditText) findViewById(R.id.editTextPasswordToLogin);

		Button btnSignIn = (Button) findViewById(R.id.buttonSignIn);

		final ILoginUser activity = this;
		btnSignIn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				editTextUserName.setError(null);
				boolean errors = false;
				if (editTextUserName.getText().toString().trim().equalsIgnoreCase("")) {
					editTextUserName.setError("This field can not be blank");
					errors = true;
				}
				editTextPassword.setError(null);
				if (editTextPassword.getText().toString().trim().equalsIgnoreCase("")) {
					editTextPassword.setError("This field can not be blank");
					errors = true;
				}
				if (!errors) {
					LoginApi login = new LoginApi(activity);
					login.doLogin(editTextUserName.getText().toString(), editTextPassword.getText().toString());
				}
			}
		});
	}

	@Override
	public void onLogin(User u) {
		Toast.makeText(getApplicationContext(), "Logged In Sucessfully" + u.getEmail(), Toast.LENGTH_SHORT).show();

		Intent intent = new Intent(this, TicketListActivity.class);
		startActivity(intent);

	}

	@Override
	public void onLoginFailure(String reason) {
		System.out.println("In onLoginFailure Method");
		Toast.makeText(getApplicationContext(), "Invalid User!!Try Again" + reason, Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

	}

}
