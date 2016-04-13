package jane.course.java.spring.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_role")
public class UserRole implements java.io.Serializable {

	private UserRoleId id;

	public UserRole() {
	}

	public UserRole(UserRoleId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "username", column = @Column(name = "username", nullable = false, length = 32) ),
			@AttributeOverride(name = "role", column = @Column(name = "role", nullable = false, length = 32) ) })
	public UserRoleId getId() {
		return this.id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + "]";
	}
}