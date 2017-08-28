package io.khasang.teamnote.entity;

import javax.persistence.*;
import java.util.HashSet;
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
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PASSWORD")
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Items> userItems = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Items> getUserItems() {
		return userItems;
	}

	public void setUserItems(Set<Items> userItems) {
		this.userItems = userItems;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"accountName='" + accountName + '\'' +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", id=" + id +
				", lastName='" + lastName + '\'' +
				", password='" + password + '\'' +
				", userItems=" + userItems +
				'}';
	}
}
