package com.qurater.csr.storage;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoggedInUserStore {
	
	public static void storeLoggedInUser(Context context, JSONObject user) {
        if (context != null) {
            final SharedPreferences prefs = context.getSharedPreferences("com.qurater.pivotal.user_preferences", Context.MODE_PRIVATE);
            Editor editor = prefs.edit();
            editor.putString("user", user.toString());
            editor.apply();
        }
    }
    
    /**
     * Store recent documents
     */
    public static void clearLoggedInUser(Context context) {
        if (context != null) {
            final SharedPreferences prefs = context.getSharedPreferences("com.qurater.pivotal.user_preferences", Context.MODE_PRIVATE);
            Editor editor = prefs.edit();
            editor.putString("user", null);
            editor.apply();
        }
    }
    
    public static JSONObject getLoggedInUser(Context context) {
        if (context != null) {
            final SharedPreferences prefs = context.getSharedPreferences("com.qurater.pivotal.user_preferences", Context.MODE_WORLD_READABLE);
            String sUser = prefs.getString("user", null);
            try {
                return new JSONObject(sUser);
            } catch(Exception e) {
                return null;
            }
        }
        return null;
    }
    
    public static Long getLoggedInUserId(Context context) {
        return getUserLongProperty(context, "id");
    }
        
    public static String getLoggedInUserName(Context context) {
    	return getUserProperty(context, "name");
    }
    
    public static String getLoggedInUserEmail(Context context) {
    	return getUserProperty(context, "email");
    }
    
    public static String getLoggedInUserToken(Context context) {
    	return getUserProperty(context, "api_token");
    }
    
    public static boolean isLoggedIn(Context context) {
        if (context != null) {
            return (getLoggedInUser(context) != null);
        }
        return false;
    }
    
    
        
    private static String getUserProperty(Context context, String property) {
        JSONObject user = getLoggedInUser(context);
        String result = null;
        try {
        	if(user != null){	        	
				result = user.getString(property);
        	}
		} catch (JSONException e) {}
        return result;
    }
    
    private static Long getUserLongProperty(Context context, String property) {
        JSONObject user = getLoggedInUser(context);
        Long result = null;
        try {
        	if(user != null){
        		result = user.getLong(property);
        	}
		} catch (JSONException ignnore) {}
        return result;
    }

}
