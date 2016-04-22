package jane.course.java.datatable.domain;

import java.util.List;
import java.util.Map;

/**
 * 实体类，用于接收DataTable传入参数 
 * @author 张铁军
 */
public class DataTablesRequest {
	
	private int draw;
	private int length;						// 当前页长度
	private int start;							// 第几页
	private Map<String, String> search;		// 查询条件
	private List<Map<String, String>> order;	// 排序
	
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public Map<String, String> getSearch() {
		return search;
	}
	public void setSearch(Map<String, String> search) {
		this.search = search;
	}
	public List<Map<String, String>> getOrder() {
		return order;
	}
	public void setOrder(List<Map<String, String>> order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "DataTablesRequest [draw=" + draw + ", length=" + length + ", start=" + start + ", search=" + search + ", order=" + order + "]";
	}
}
