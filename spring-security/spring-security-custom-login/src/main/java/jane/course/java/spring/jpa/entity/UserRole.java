package jane.course.java.spring.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_role", catalog = "test")
public class UserRole implements java.io.Serializable {
	
	private UserRoleId id;
	private Role role;
	private Users users;

	public UserRole() {
	}

	public UserRole(UserRoleId id, Role role, Users users) {
		this.id = id;
		this.role = role;
		this.users = users;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}