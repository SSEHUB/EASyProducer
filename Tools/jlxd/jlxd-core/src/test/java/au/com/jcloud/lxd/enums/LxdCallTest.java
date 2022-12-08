package au.com.jcloud.lxd.enums;

import org.junit.Assert;
import org.junit.Test;

import au.com.jcloud.lxd.enums.LxdCall;
import au.com.jcloud.lxd.service.ILxdApiService;


public class LxdCallTest {

	@Test
	public void test() {
		Assert.assertEquals(ILxdApiService.URL_GET_CERTIFICATE,LxdCall.GET_CERTIFICATE.getCommand());
	}
}
