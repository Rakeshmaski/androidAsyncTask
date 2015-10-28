package com.qurater.csr.api;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseRecord {

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public long getCommentCreateDate() {
		return commentCreateDate;
	}

	public void setCommentCreateDate(long commentCreateDate) {
		this.commentCreateDate = commentCreateDate;
	}

	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	private String createDate;
	private String updateDate;
	private boolean deleted;
	private String id;
	private long postId;
	private long commentId;
	private String message;
	private String fromUserName;
	private String fromUserId;
	private long commentCreateDate;
	private long likeCount;

	private String category1;
	private String category2;
	private String sentiment;

	private FacebookPost facebookPosts;

	public FacebookPost getFacebookPosts() {
		return facebookPosts;
	}

	public void setFacebookPosts(FacebookPost facebookPosts) {
		this.facebookPosts = facebookPosts;
	}

	public static BaseRecord fromJson(JSONObject json) throws JSONException {
		System.out.println("In BaseRecord : fromJson method");
		BaseRecord b = new BaseRecord();

		if (json.has("category1")) {
			System.out.println("category1=" + json.getString("category1"));
		}

		if (json.has("fromUserName")) {
			System.out.println("fromUserName=" + json.getString("fromUserName"));
		}

		if (json.has("message")) {
			b.setMessage(json.getString("message"));
			System.out.println("message=" + json.getString("message"));
		}
		if (json.has("sentiment")) {
			b.setSentiment(json.getString("sentiment"));
		}
		if (json.has("fromUserId")) {
			b.setFromUserId(json.getString("fromUserId"));
		}
		if (json.has("id")) {
			b.setId(json.getString("id"));
		}

		JSONObject facebookPost = json.getJSONObject("facebookPost");
		FacebookPost f = FacebookPost.fromJson(facebookPost);
		b.setFacebookPosts(f);
		return b;

	}

}
