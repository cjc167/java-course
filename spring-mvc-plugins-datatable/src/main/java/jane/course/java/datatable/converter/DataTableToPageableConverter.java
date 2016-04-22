package jane.course.java.datatable.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jane.course.java.datatable.domain.DataTablesRequest;

/**
 * 转换类。将DataTablesRequest类型转换为Pageable类型
 * @author zhang
 */
public class DataTableToPageableConverter implements Converter<DataTablesRequest, Pageable> {

	private Class<?> clazz;
	
	public DataTableToPageableConverter(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Pageable convert(DataTablesRequest request) {
		if(request == null) return null;
		
		Sort sort = new DataTableToSortConverter(clazz).convert(request);
		
		int page = request.getStart() / request.getLength();
		int size = request.getLength();
		return new PageRequest(page, size, sort);
	}
}
