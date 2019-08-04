package com.maintain.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class MaintainenanceTicket {
	private Long id;
	private LocalDateTime workDoneDate;
	private String workType;
	private String workDescription;
	private String workMaintenanceNotes;

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public LocalDateTime getSentDate() {
		return workDoneDate;
	}

	public Date getSentDateAsDate() {
		Instant instant = workDoneDate.toInstant(ZoneOffset.of("-5"));
		return Date.from(instant);
	}

	public void setSentDate(LocalDateTime sentDate) {
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
