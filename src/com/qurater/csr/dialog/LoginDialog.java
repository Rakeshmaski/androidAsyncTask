package com.qurater.csr.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.qurater.csr.activity.MainActivity;
import com.qurater.csr.activity.R;
import com.qurater.csr.api.User;
import com.qurater.csr.interfaces.ILoginUser;

public class LoginDialog extends DialogFragment implements ILoginUser{
    
    protected Activity activity;
    
    public LoginDialog(Activity activity) {
        super();
        this.activity = activity;
    }
    /** The system calls this to get the DialogFragment's layout, regardless
        of whether it's being displayed as a dialog or an embedded fragment. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout to use as dialog or embedded fragment
        View view = inflater.inflate(R.layout.dialog_login, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        int style = DialogFragment.STYLE_NORMAL, theme = android.R.style.Theme_Holo_Light_Dialog;
        setStyle(style, theme);
        return view;
    }  
    
    @Override
    public void onStart() {
    	super.onStart();
    	// safety check
    	if (getDialog() == null) {
    		return;
    	}
    }
    	
    	
            
            
	        
     

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    

	@Override
	public Context getApplicationContext() {
		return activity;
	}
	
	@Override
	public void onLogin(User u) {
		Intent intent = new Intent(activity, MainActivity.class);
        startActivity(intent);
        activity.finish();
	}
	
	@Override
	public void onLoginFailure(String reason) {
		TextView loginError = (TextView)getView().findViewById(R.id.login_error);
		loginError.setVisibility(View.VISIBLE);
		loginError.setText(reason);
	}
	@Override
	public void finish() {
		
	}	

}