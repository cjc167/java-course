package jane.course.java.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "operation", catalog = "test")
public class Operation implements java.io.Serializable {

	private String operate;
	private String name;

	public Operation() {}

	public Operation(String operate, String name) {
		this.operate = operate;
		this.name = name;
	}

	@Id
	@Column(name = "operate", unique = true, nullable = false, length = 16)
	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}