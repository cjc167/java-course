package jane.course.java.spring.mvc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionAttribute {
	/**
     * The name of the request attribute to bind to.
     */
	String value() default "";
	 
    /**
     * Whether the parameter is required.
     * Default is true, leading to an exception thrown in case
     * of the parameter missing in the request. Switch this to
     * false if you prefer a null in case of the parameter missing.
     * Alternatively, provide a {@link #defaultValue() defaultValue},
     * which implicitly sets this flag to false.
     */
    boolean required() default true;
 
    /**
     * The default value to use as a fallback. Supplying a default value
     * implicitly sets {@link #required()} to false.
     */
    String defaultValue() default "";
}
