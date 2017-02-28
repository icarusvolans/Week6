package com.davida.finalApp.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
//@Table(name = "sign_request")
public class EditRequest {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name="team_member_request", joinColumns=@JoinColumn(name="edit_request_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	private Collection<User> users;


//	@NotNull
	@Column(name = "deliverable")
	private String deliverable;

//    @NotNull
	@Column(name = "copy", columnDefinition = "TEXT")
	private String copy;

	@Column(name="flagged_deleted", nullable = true)
	private boolean flaggedDeleted;

    @Column(name="date_time", columnDefinition="timestamp", nullable = true)
//    @Convert(converter = LocalDateTimeAttributeConverter.class)
    LocalDateTime dateTime = LocalDateTime.now();

	public EditRequest() {
	}

	public EditRequest(Long id, Collection<User> users, String deliverable, String copy, boolean flaggedDeleted, LocalDateTime dateTime) {
		this.id = id;
		this.users = users;
		this.deliverable = deliverable;
		this.copy = copy;
		this.flaggedDeleted = flaggedDeleted;
        this.dateTime = dateTime;

	}

	public EditRequest(Collection<User> users, String deliverable, String copy, boolean flaggedDeleted) {
		this.users = users;
		this.deliverable = deliverable;
		this.copy = copy;
		this.flaggedDeleted = flaggedDeleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
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

	public boolean isFlaggedDeleted() {
		return flaggedDeleted;
	}

	public void setFlaggedDeleted(boolean flaggedDeleted) {
		this.flaggedDeleted = flaggedDeleted;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return String.format("EditRequest[id=%d , deliverable='%s', copy='%s', flaggedDeleted='%b', dateTime='US: %tB %<te,  %<tY  %<tT %<Tp%n' ]", id, deliverable, copy, flaggedDeleted, dateTime);
	}
}
