package au.com.jcloud.lxd.service.impl;

import org.junit.Assert;
import org.junit.Test;

import au.com.jcloud.lxd.service.impl.LinuxCliServiceImpl;

public class LinuxCliServiceImplTest {

	private LinuxCliServiceImpl linuxCliService = new LinuxCliServiceImpl();

	@Test
	public void getFileNameWithoutExtension() {
		String result = linuxCliService.getFileNameWithoutExtension("test.two");
		Assert.assertEquals("test", result);
		
		result = linuxCliService.getFileNameWithoutExtension("test");
		Assert.assertEquals("test", result);
	}
	
	@Test
	public void getFileExtension() {
		String result = linuxCliService.getFileExtension("test.two");
		Assert.assertEquals("two", result);
		
		result = linuxCliService.getFileExtension("try.test.two");
		Assert.assertEquals("two", result);
	}
	
	@Test
	public void firstCharUpperCase() {
		String result = linuxCliService.firstCharUpperCase("testTwo");
		Assert.assertEquals("TestTwo", result);
		
		result = linuxCliService.firstCharUpperCase("TestTwo");
		Assert.assertEquals("TestTwo", result);
	}
	

}
