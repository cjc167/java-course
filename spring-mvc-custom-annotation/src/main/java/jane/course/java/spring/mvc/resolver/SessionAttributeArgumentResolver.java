package jane.course.java.spring.mvc.resolver;

import jane.course.java.spring.mvc.annotation.SessionAttribute;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class SessionAttributeArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annotation : annotations) {
            if (SessionAttribute.class.isInstance(annotation))
                return true;
        }
        return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annotation : annotations) {
            if (SessionAttribute.class.isInstance(annotation)) {
            	SessionAttribute ann = (SessionAttribute) annotation;
                String name = ann.value();
                HttpServletRequest httprequest = (HttpServletRequest)webRequest.getNativeRequest();
                return httprequest.getSession().getAttribute(name);
            }
        }
        return null;
	}
//
//	@Override
//	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
//		Annotation[] annotations = methodParameter.getParameterAnnotations();
//
//		Class<?> paramType = methodParameter.getParameterType();
//
//		for (Annotation annotation : annotations) {
//			if (SessionAttribute.class.isInstance(annotation)) {
//				SessionAttribute sessionAttribute = (SessionAttribute) annotation;
//				HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
//				Object result = request.getSession().getAttribute(sessionAttribute.value());
//
//				if (result == null)
//					result = sessionAttribute.defaultValue();
//
//				if (result == null && sessionAttribute.required())
//					raiseMissingParameterException(sessionAttribute.value(), paramType);
//				else
//					return result;
//			}
//		}
//
//		return WebArgumentResolver.UNRESOLVED;
//	}
//
//	protected void raiseMissingParameterException(String paramName, Class<?> paramType) throws Exception {
//		throw new IllegalStateException("Missing parameter '" + paramName + "' of type [" + paramType.getName() + "]");
//	}
}
