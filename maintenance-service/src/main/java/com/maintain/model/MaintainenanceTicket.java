package com.maintain.model;

public class MaintainenanceTicket {
	private Long id;
	private String workDoneDate;
	private String workType;
	private String workDescription;
	private String workMaintenanceNotes;

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public String getSentDate() {
		return workDoneDate;
	}

	public void setSentDate(String sentDate) {
		this.workDoneDate = sentDate;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	// Required
	public String getMessage() {
		return workDescription;
	}

	public void setMessage(String message) {
		this.workDescription = message;
	}

	public String getWorkMaintenanceNotes() {
		return workMaintenanceNotes;
	}

	public void setWorkMaintenanceNotes(String workMaintenanceNotes) {
		this.workMaintenanceNotes = workMaintenanceNotes;
	}

}
