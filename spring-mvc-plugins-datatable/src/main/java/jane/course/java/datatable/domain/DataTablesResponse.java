package jane.course.java.datatable.domain;

import java.util.List;

public class DataTablesResponse<T> {
	
	private int recordsTotal;		//过滤前的总条数
	private int recordsFiltered;	//过滤后的条数
	private List<T> data;
	
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "DataTablesResponse [recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", data=" + data + "]";
	}
}
