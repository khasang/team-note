package io.khasang.teamnote.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This class represents a user. It includes attributes that identify a person ({@link #firstName}, {@link #lastName}),
 * identify an application user ({@link #accountName}) and enable authentication ({@link #password}).
 * 
 * @author MickeyMouse
 */
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ACCOUNT_NAME" }, name = "users_unique_account_name"),
		@UniqueConstraint(columnNames = { "EMAIL" }, name = "users_unique_email") })
public class User {

	/**
	 * The name of the user's account in the application. It is used to distinguish users in the application, it is used
	 * also for login.
	 */
	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

	public String getAccountName() {
		return accountName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
