package jane.course.java.datatable.converter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.google.gson.Gson;

import jane.course.java.datatable.domain.DataTablesRequest;

/**
 * 转换类。将DataTablesRequest类型转换为Sort类型
 * @author zhang
 */
public class DataTableToSortConverter implements Converter<DataTablesRequest, Sort> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private Class<?> clazz;

	public DataTableToSortConverter(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Sort convert(DataTablesRequest request) {
		if(request == null) return null;
		
		List<Map<String, String>> orderList = request.getOrder();
		if(orderList == null || orderList.isEmpty()) return null;

		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		for(Map<String, String> map: orderList){
			if(map == null || map.isEmpty()) continue;
			Direction direction = Direction.ASC;
			String property = null;
			
			Set<Map.Entry<String, String>> entrySet = map.entrySet();
			for(Map.Entry<String, String> entry: entrySet){
				// column=2, dir=desc
				String key = entry.getKey();
				String value = entry.getValue();
				if(StringUtils.isBlank(key)) continue;
				
				if("column".equals(key)){
					if(value.matches("\\d+")){
						int index = Integer.parseInt(value);
						Field[] fields = clazz.getDeclaredFields();
						
						if(index < 0 || index > fields.length) continue;
						
						property = fields[index].getName();
					}
				}
				
				if("dir".equals(key)){
					direction = Direction.fromString(value);
				}
			}
			
			if(property != null){
				Order order = new Order(direction, property);
				orders.add(order);
			}
		}
		
		logger.info(new Gson().toJson(new Sort(orders)));
		
		return orders.isEmpty()? null : new Sort(orders);
	}
}
