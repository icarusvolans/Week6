package com.example.batchcsvpostgresql.model;

public class SignRequest {
	private long id;
	private String launchDate;
	private String program;
	private String department;
	private String deliverable;
	private String copy;

	public SignRequest() {
	}

	public SignRequest(long id, String launchDate, String program, String department, String deliverable, String copy) {
		this.id = id;
		this.launchDate = launchDate;
		this.program = program;
		this.department = department;
		this.deliverable = deliverable;
		this.copy = copy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDeliverable() {
		return deliverable;
	}

	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}

	public String getCopy() {
		return copy;
	}

	public void setCopy(String copy) {
		this.copy = copy;
	}

	@Override
	public String toString() {
		return String.format("SignRequest[id=%d , launchDate='%s', program='%s', department='%s', deliverable='%s', copy='%s']", id, launchDate, program, department, deliverable, copy);
	}
}
