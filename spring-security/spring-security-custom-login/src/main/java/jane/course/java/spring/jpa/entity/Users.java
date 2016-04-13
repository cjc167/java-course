package jane.course.java.spring.jpa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "users", catalog = "test")
public class Users implements java.io.Serializable {

	private String username;
	private String password;
	private String salt;
	private Boolean enabled;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public Users() {
	}

	public Users(String username, String password, String salt, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.enabled = enabled;
	}

	public Users(String username, String password, String salt, Boolean enabled, Set<UserRole> userRoles) {
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", nullable = false, length = 36)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}