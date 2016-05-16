package jane.course.java.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import jane.course.java.spring.mvc.annotation.Discount;

public class DiscountValidator implements ConstraintValidator<Discount, String> {

	@Override
	public void initialize(Discount constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// 如果为空或者不是数字，则验证不通过
		if(StringUtils.isBlank(value) || !StringUtils.isNumeric(value)) return false;

		// 不是3位数字，则验证不通过
		if(!value.matches("\\d{1, 3}")) return false;
		
		int discount = 0;
		try {
			discount = Integer.parseInt(value);
		} catch (Exception e) {
			// 整型转换失败，验证不通过
			return false;
		}
		
		// 验证是否在 1 - 100范围内
		return discount > 0 && discount <= 100;
	}
}
