package jane.course.java.spring.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "role_resource")
public class RoleResource implements java.io.Serializable {

	private RoleResourceId id;
	private String path;

	public RoleResource() {
	}

	public RoleResource(RoleResourceId id, String path) {
		this.id = id;
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

	@Column(name = "path", nullable = false, length = 256)

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "RoleResource [id=" + id + ", path=" + path + "]";
	}
}