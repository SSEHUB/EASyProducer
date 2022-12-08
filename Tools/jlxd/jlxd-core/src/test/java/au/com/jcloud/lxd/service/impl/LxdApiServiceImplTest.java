package au.com.jcloud.lxd.service.impl;

import org.junit.Assert;
import org.junit.Test;

import au.com.jcloud.lxd.LxdConstants;
import au.com.jcloud.lxd.bean.LxdServerCredential;

/**
 * Created by david.vittor on 12/07/16.
 */
public class LxdApiServiceImplTest {

	private LxdApiServiceImpl lxdApiService = new LxdApiServiceImpl();

	@Test
	public void getBaseUrl() {
		String result = lxdApiService.getBaseUrl(null);
		Assert.assertEquals(lxdApiService.CURL_URL_BASE_LOCAL, result);

		result = lxdApiService.getBaseUrl(new LxdServerCredential());
		Assert.assertEquals(lxdApiService.CURL_URL_BASE_LOCAL, result);

		LxdServerCredential credential = new LxdServerCredential("test");
		result = lxdApiService.getBaseUrl(credential);
		Assert.assertEquals("curl -s -k --cert " + LxdConstants.DEFAULT_FILEPATH_REMOTE_CERT + " --key " + LxdConstants.DEFAULT_FILEPATH_REMOTE_KEY + " https://test:8443", result);

		credential = new LxdServerCredential("10.1.1.5:8080", "~/.config/lxc/client.crt", "~/.config/lxc/client.key");
		result = lxdApiService.getBaseUrl(credential);
		Assert.assertEquals("curl -s -k --cert ~/.config/lxc/client.crt --key ~/.config/lxc/client.key https://10.1.1.5:8080", result);

		credential.setRemoteHostAndPort("10.1.1.5");
		credential.setRemoteCert("/test/client.crt");
		credential.setRemoteKey("/test/client.key");
		result = lxdApiService.getBaseUrl(credential);
		Assert.assertEquals("curl -s -k --cert /test/client.crt --key /test/client.key https://10.1.1.5:8443", result);

	}

	@Test
	public void getParameterisedUrl() {
		String url = "a${ID}:${ID}";
		String id = "b";
		String result = lxdApiService.getParameterisedUrl(url, id);
		Assert.assertEquals("ab:b", result);
	}

}
