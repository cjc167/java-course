package jane.course.java.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class UserRoleId implements java.io.Serializable {

	private String username;
	private String role;

	public UserRoleId() {
	}

	public UserRoleId(String username, String role) {
		this.username = username;
		this.role = role;
	}

	@Column(name = "username", nullable = false, length = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "role", nullable = false, length = 32)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getRole() == castOther.getRole()) || (this.getRole() != null && castOther.getRole() != null
						&& this.getRole().equals(castOther.getRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getRole() == null ? 0 : this.getRole().hashCode());
		return result;
	}
}