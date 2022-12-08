package au.com.jcloud.jlxd.ui.search;

import java.util.Collection;

public class AjaxResponseBody<T> {

	String msg;
	Collection<T> result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Collection<T> getResult() {
		return result;
	}

	public void setResult(Collection<T> result) {
		this.result = result;
	}
}
