package com.qurater.csr.api;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookPost {

	private String pageId;
	private long postId;
	private String link;
	private String category;
	private String message;
	private String text;
	private String organization;
	private String channelType;
	private String fromUserName;
	private String icon;

	private String statusType;
	private long postCreateDate;
	private long postUpdateDate;
	private String type;
	private long createDate;
	private long updateDate;
	private long id;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public long getPostCreateDate() {
		return postCreateDate;
	}

	public void setPostCreateDate(long postCreateDate) {
		this.postCreateDate = postCreateDate;
	}

	public long getPostUpdateDate() {
		return postUpdateDate;
	}

	public void setPostUpdateDate(long postUpdateDate) {
		this.postUpdateDate = postUpdateDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public long getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(long updateDate) {
		this.updateDate = updateDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public static FacebookPost fromJson(JSONObject json) throws JSONException {
		System.out.println("In FacebookPost: fromJson");
		FacebookPost f = new FacebookPost();
		f.setMessage(json.getString("message"));
		System.out.println("message=" + json.getString("message"));

		f.setIcon(json.getString("icon"));
		System.out.println(json.getString("icon"));
		 

		f.setOrganization(json.getString("organization"));
		System.out.println("organization=" + json.getString("organization"));

		return f;

	}
}
