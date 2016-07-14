package ua.busstation.core.user;

import java.io.Serializable;

/**
 * User entity.
 * 
 * @author O.Soklakov
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6889036256149495388L;

	private Long id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private int roleId;

	public User() {
	}

	public User(Long id, String login, String password, String firstName, String lastName, int routeId) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = routeId;
	}
	
	public User(String login, String password, String firstName, String lastName, int routeId) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = routeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", firstName=" + firstName + ", lastName=" + lastName + ", roleId=" + roleId
				+ "]";
	}

}
