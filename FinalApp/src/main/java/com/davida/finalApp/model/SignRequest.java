package com.davida.finalApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "sign_request")
public class SignRequest {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@NotNull
//	@Column(name = "Launch Date")
	private String launchDate;

//	@NotNull
//	@Column(name = "Program")
	private String program;

//	@NotNull
//	@Column(name = "Department")
	private String department;

//	@NotNull
//	@Column(name = "Deliverable")
	private String deliverable;

//    @NotNull
	@Column(name = "Copy", columnDefinition = "TEXT")
	private String copy;

	public SignRequest() {
	}

	public SignRequest(Long id, String launchDate, String program, String department, String deliverable, String copy) {
		this.id = id;
		this.launchDate = launchDate;
		this.program = program;
		this.department = department;
		this.deliverable = deliverable;
		this.copy = copy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
