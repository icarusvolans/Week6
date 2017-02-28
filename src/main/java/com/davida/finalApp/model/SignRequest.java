package com.davida.finalApp.model;

//import com.davida.finalApp.converter.LocalDateTimeAttributeConverter;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
//@Table(name = "sign_request")
public class SignRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@NotNull
	@Column(name = "launch_date")
	private String launchDate;

//	@NotNull
	@Column(name = "program")
	private String program;

//	@NotNull
	@Column(name = "department")
	private String department;

//	@NotNull
	@Column(name = "deliverable")
	private String deliverable;

//    @NotNull
	@Column(name = "copy", columnDefinition = "TEXT")
	private String copy;

    @Column(name = "edit_deliverable", columnDefinition = "TEXT", nullable = true)
    private String editDeliverable;

    @Column(name = "edit_copy", columnDefinition = "TEXT", nullable = true)
    private String editCopy;

    @Column(name="flagged_deleted", nullable = true)
    private boolean flaggedDeleted;

	@Column(name = "username", nullable = true)
	private String username;

    @Column(name="edit_date_time", columnDefinition="timestamp", nullable = true)
//    @Convert(converter = LocalDateTimeAttributeConverter.class)
    LocalDateTime editDateTime = LocalDateTime.now();

	public SignRequest() {
	}

	public SignRequest(Long id, String launchDate, String program, String department, String deliverable, String copy, String editDeliverable, String editCopy, boolean flaggedDeleted,  String username, LocalDateTime editDateTime) {
		this.id = id;
		this.launchDate = launchDate;
		this.program = program;
		this.department = department;
		this.deliverable = deliverable;
		this.copy = copy;
        this.editDeliverable = editDeliverable;
        this.editCopy = editCopy;
        this.flaggedDeleted = flaggedDeleted;
		this.username = username;
        this.editDateTime = editDateTime;

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

    public String getEditDeliverable() {
        return editDeliverable;
    }

    public void setEditDeliverable(String editDeliverable) {
        this.editDeliverable = editDeliverable;
    }

    public String getEditCopy() {
        return editCopy;
    }

    public void setEditCopy(String editCopy) {
        this.editCopy = editCopy;
    }

    public boolean isFlaggedDeleted() {
        return flaggedDeleted;
    }

    public void setFlaggedDeleted(boolean flaggedDeleted) {
        this.flaggedDeleted = flaggedDeleted;
    }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public LocalDateTime getEditDateTime() {
        return editDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }

    @Override
	public String toString() {
		return String.format("SignRequest[id=%d , launchDate='%s', program='%s', department='%s', deliverable='%s', copy='%s', editDeliverable='%s', editCopy='%s', flaggedDeleted='%b', username='%s',editDateTime='US: %tB %<te,  %<tY  %<tT %<Tp%n' ]", id, launchDate, program, department, deliverable, copy, editDeliverable, editCopy, flaggedDeleted, username, editDateTime);
	}
}
