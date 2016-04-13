package jane.course.java.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class RoleResourceId implements java.io.Serializable {

	private String role;
	private Integer resourceId;
	private String operate;

	public RoleResourceId() {
	}

	public RoleResourceId(String role, Integer resourceId, String operate) {
		this.role = role;
		this.resourceId = resourceId;
		this.operate = operate;
	}

	@Column(name = "role", nullable = false, length = 32)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "resource_id", nullable = false)
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "operate", nullable = false, length = 16)
	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleResourceId))
			return false;
		RoleResourceId castOther = (RoleResourceId) other;

		return ((this.getRole() == castOther.getRole()) || (this.getRole() != null && castOther.getRole() != null
				&& this.getRole().equals(castOther.getRole())))
				&& ((this.getResourceId() == castOther.getResourceId()) || (this.getResourceId() != null
						&& castOther.getResourceId() != null && this.getResourceId().equals(castOther.getResourceId())))
				&& ((this.getOperate() == castOther.getOperate()) || (this.getOperate() != null
						&& castOther.getOperate() != null && this.getOperate().equals(castOther.getOperate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRole() == null ? 0 : this.getRole().hashCode());
		result = 37 * result + (getResourceId() == null ? 0 : this.getResourceId().hashCode());
		result = 37 * result + (getOperate() == null ? 0 : this.getOperate().hashCode());
		return result;
	}
}