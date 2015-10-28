package com.qurater.csr.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class History {

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedByRep() {
		return updatedByRep;
	}

	public void setUpdatedByRep(String updatedByRep) {
		this.updatedByRep = updatedByRep;
	}

	public String getTicketEventType() {
		return ticketEventType;
	}

	public void setTicketEventType(String ticketEventType) {
		this.ticketEventType = ticketEventType;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	private String createDate;
	private String updateDate;
	private long id;
	private long ticketId;
	private String reason;
	private long assignedTo;
	private long status;
	private String reasonCode;
	private String updatedBy;
	private String updatedByRep;
	private String ticketEventType;
	private boolean deleted;

	public static History fromJson(JSONObject json) throws JSONException {
		History h = new History();
		System.out.println("In History:fromJSON");
		
		if(json.has("ticketEventType")){
			h.setTicketEventType(json.getString("ticketEventType"));	
		}
		
		if(json.has("assignedTo")){
			h.setAssignedTo(json.getLong("assignedTo"));	
		}
		
		if(json.has("deleted")){
			h.setDeleted(json.getBoolean("deleted"));	
		}
		
		if(json.has("reason")){
			h.setReason(json.getString("reason"));
		}

		if(json.has("reasonCode")){
			h.setReasonCode(json.getString("reasonCode"));
		}
		
		if(json.has("updatedBy")){
			h.setUpdatedBy(json.getString("updatedBy"));
		}
		
		if(json.has("updatedByRep")){
			h.setUpdatedByRep(json.getString("updatedByRep"));
		}
		return h;
	}

}
