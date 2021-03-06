package jane.course.java.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class Role implements java.io.Serializable {

	private String role;
	private String name;
	private String description;

	public Role() {
	}

	public Role(String role, String name) {
		this.role = role;
		this.name = name;
	}

	public Role(String role, String name, String description) {
		this.role = role;
		this.name = name;
		this.description = description;
	}

	@Id
	@Column(name = "role", unique = true, nullable = false, length = 32)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", name=" + name + ", description=" + description + "]";
	}
}