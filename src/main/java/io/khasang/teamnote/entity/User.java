package io.khasang.teamnote.entity;

import javax.persistence.*;
import java.util.Set;

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

	@OneToMany(mappedBy = "user")
	private Set<Order> order;

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
}
