package com.qurater.csr.api;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDisplayImage() {
		return displayImage;
	}

	public void setDisplayImage(String displayImage) {
		this.displayImage = displayImage;
	}

	public Long getLastLoggedIn() {
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Long lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	public Long getActive() {
		return active;
	}

	public void setActive(Long active) {
		this.active = active;
	}

	private String email;
	private String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String firstName;
	private String lastName;
	private String facebookId;
	private String imageUrl;
	private String displayImage;
	private Long lastLoggedIn;
	private Long active;

	public static User fromJson(JSONObject json) throws JSONException {
		User u = new User();
		u.setId(json.getLong("id"));
		System.out.println("user id"+json.getLong("id"));
		u.setUserName(json.getString("userName"));
		System.out.println("user name"+json.getString("userName"));
		return u;
	}
}
