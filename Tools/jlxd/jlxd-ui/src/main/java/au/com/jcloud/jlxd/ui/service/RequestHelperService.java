package au.com.jcloud.jlxd.ui.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class RequestHelperService {

	public <T> T getAttributeFromSession(HttpServletRequest request, String key) {
		@SuppressWarnings("unchecked")
		T value = (T) request.getSession().getAttribute(key);
		return value;
	}

	public void setAttributeInSession(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}

	public void removeAttributeFromSession(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}

}
