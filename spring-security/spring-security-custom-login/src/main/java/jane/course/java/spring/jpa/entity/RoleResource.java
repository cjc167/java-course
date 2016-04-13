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
@Table(name = "role_resource", catalog = "test")
public class RoleResource implements java.io.Serializable {
	
	private RoleResourceId id;
	private Resource resource;
	private Role role;
	private Operation operation;
	private String path;

	public RoleResource() {
	}
	
	public RoleResource(RoleResourceId id, Resource resource, Role role, Operation operation, String path) {
		this.id = id;
		this.resource = resource;
		this.role = role;
		this.operation = operation;
		this.path = path;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "role", column = @Column(name = "role", nullable = false, length = 32) ),
			@AttributeOverride(name = "resourceId", column = @Column(name = "resource_id", nullable = false) ),
			@AttributeOverride(name = "operate", column = @Column(name = "operate", nullable = false, length = 16) ) })
	public RoleResourceId getId() {
		return this.id;
	}

	public void setId(RoleResourceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id", nullable = false, insertable = false, updatable = false)
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
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
	@JoinColumn(name = "operate", nullable = false, insertable = false, updatable = false)
	public Operation getOperation() {
		return this.operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Column(name = "path", nullable = false, length = 256)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}