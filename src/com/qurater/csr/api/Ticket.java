package com.qurater.csr.api;

import org.json.JSONException;
import org.json.JSONObject;

public class Ticket {

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedToRep() {
		return assignedToRep;
	}

	public void setAssignedToRep(String assignedToRep) {
		this.assignedToRep = assignedToRep;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getChannelRecordId() {
		return channelRecordId;
	}

	public void setChannelRecordId(String channelRecordId) {
		this.channelRecordId = channelRecordId;
	}

	public String getChannelRecord() {
		return channelRecord;
	}

	public void setChannelRecord(String channelRecord) {
		this.channelRecord = channelRecord;
	}

	public String getSlaviolation() {
		return slaviolation;
	}

	public void setSlaviolation(String slaviolation) {
		this.slaviolation = slaviolation;
	}

	public String getOrigSource() {
		return origSource;
	}

	public void setOrigSource(String origSource) {
		this.origSource = origSource;
	}

	public String getParentTicketId() {
		return parentTicketId;
	}

	public void setParentTicketId(String parentTicketId) {
		this.parentTicketId = parentTicketId;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactCountryCode() {
		return contactCountryCode;
	}

	public void setContactCountryCode(String contactCountryCode) {
		this.contactCountryCode = contactCountryCode;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getBookmarked() {
		return bookmarked;
	}

	public void setBookmarked(String bookmarked) {
		this.bookmarked = bookmarked;
	}

	public long getSentiment() {
		return sentiment;
	}

	public void setSentiment(long sentiment) {
		this.sentiment = sentiment;
	}

	public long getOrigDate() {
		return origDate;
	}

	public void setOrigDate(long origDate) {
		this.origDate = origDate;
	}

	public long getOodjaCreateDate() {
		return oodjaCreateDate;
	}

	public void setOodjaCreateDate(long oodjaCreateDate) {
		this.oodjaCreateDate = oodjaCreateDate;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	private String updateDate;
	private String deleted;
	private String createdBy;
	private String customerId;
	private String updatedBy;
	private String assignedTo;
	private String assignedToRep;
	private String status;
	private History history;
	private String objectType;
	private String channelRecordId;
	private String channelRecord;
	private String id;
	private String createDate;
	private BaseRecord baseRecords;
	private String slaviolation;
	private String origSource;
	private String parentTicketId;
	private String customField1;
	private String customField2;
	private String firstName;
	private String lastName;
	private String userName;
	private String contactCountryCode;
	private long contactNumber;
	private String email;
	private String city;
	private String state;
	private String zone;
	private String priority;
	private String ticketType;
	private String bookmarked;
	private long sentiment;
	private long origDate;
	private long oodjaCreateDate;
	private String guid;
	private String fromUser;

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
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

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getCategory4() {
		return category4;
	}

	public void setCategory4(String category4) {
		this.category4 = category4;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getOrigId() {
		return origId;
	}

	public void setOrigId(long origId) {
		this.origId = origId;
	}

	private String category1;
	private String category2;
	private String category3;
	private String category4;
	private String text;
	private long origId;

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseRecord getBaseRecords() {
		return baseRecords;
	}

	public void setBaseRecords(BaseRecord baseRecords) {
		this.baseRecords = baseRecords;
	}

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

	public static Ticket fromJson(JSONObject json) throws JSONException {
		Ticket p = new Ticket();
		System.out.println("In Ticket : fromJson method");
		if (json.has("createDate")) {
			p.setCreateDate(json.getString("createDate"));
			System.out.println("createDate=" + json.getString("createDate"));
		}

		if (json.has("updateDate")) {
			p.setUpdateDate(json.getString("updateDate"));
		}

		if (json.has("id")) {
			p.setId(json.getString("id"));
		}

		if (json.has("status")) {
			p.setStatus(json.getString("status"));
		}

		if (json.has("assignedTo")) {
			p.setAssignedTo(json.getString("assignedTo"));
		}

		if (json.has("fromUser")) {
			p.setFromUser(json.getString("fromUser"));
		}

		if (json.has("origId")) {
			p.setOrigId(json.getLong("origId"));
		}
		if (json.has("text")) {
			p.setText(json.getString("text"));
		}
		if (json.has("category1")) {
			p.setCategory1(json.getString("category1"));
		}
		if (json.has("category2")) {
			p.setCategory1(json.getString("category2"));
		}
		if (json.has("category3")) {
			p.setCategory1(json.getString("category3"));
		}
		if (json.has("category4")) {
			p.setCategory1(json.getString("category4"));
		}
		if (json.has("sentiment")) {
			p.setCategory1(json.getString("sentiment"));
		}
		if (json.has("priority")) {
			p.setPriority(json.getString("priority"));
		}
		if (json.has("ticketType")) {
			p.setTicketType(json.getString("ticketType"));
		}
		return p;
	}

}
