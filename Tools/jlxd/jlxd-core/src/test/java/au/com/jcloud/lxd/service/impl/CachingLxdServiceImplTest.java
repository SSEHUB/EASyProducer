package au.com.jcloud.lxd.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.model.Certificate;
import au.com.jcloud.lxd.model.Container;
import au.com.jcloud.lxd.model.Image;
import au.com.jcloud.lxd.model.Network;
import au.com.jcloud.lxd.model.Profile;

public class CachingLxdServiceImplTest {

	private CachingLxdServiceImpl service;

	@Before
	public void setup() {
		service = spy(CachingLxdServiceImpl.class);
	}

	@Test
	public void testRemoteHostAndPort() {
		LxdServerCredential credential = new LxdServerCredential();
		credential.setRemoteHostAndPort("test");
		service.setLxdServerCredential(credential);
		assertEquals("test", service.getLxdServerCredential().getRemoteHostAndPort());
	}

	@Test
	public void getContainerMap() throws IOException, InterruptedException {
		Map<String, Container> containerMap = new HashMap<>();
		Container container = mock(Container.class);
		containerMap.put("test", container);
		doReturn(containerMap).when(service).getContainerMap();
		Map<String, Container> result = service.getContainerMap();
		assertEquals(container, result.values().iterator().next());
		assertEquals(container, service.getContainer("test"));
	}

	@Test
	public void getContainerMap_shouldHandleException() throws IOException, InterruptedException {
		Map<String, Container> containerMap = new HashMap<>();
		Container container = mock(Container.class);
		containerMap.put("test", container);
		doThrow(new RuntimeException("error")).when(service).loadContainerMap();
		Map<String, Container> result = service.getContainerMap();
		assertEquals(0, result.size());
	}

	@Test
	public void getImageMap() throws IOException, InterruptedException {
		Map<String, Image> imageMap = new HashMap<>();
		Image image = mock(Image.class);
		imageMap.put("test", image);
		doReturn(imageMap).when(service).getImageMap();
		Map<String,Image> result = service.getImageMap();
		assertEquals(image, result.values().iterator().next());
		assertEquals(image, service.getImage("test"));
	}

	@Test
	public void getImageMap_shouldHandleException() throws IOException, InterruptedException {
		Map<String, Image> imageMap = new HashMap<>();
		Image image = mock(Image.class);
		imageMap.put("test", image);
		doThrow(new RuntimeException("error")).when(service).loadImageMap();
		Map<String,Image> result = service.getImageMap();
		assertEquals(0, result.size());
	}

	@Test
	public void getNetworks() throws IOException, InterruptedException {
		Map<String, Network> networkMap = new HashMap<>();
		Network network = mock(Network.class);
		networkMap.put("test", network);
		doReturn(networkMap).when(service).getNetworkMap();
		Map<String, Network> result = service.getNetworkMap();
		assertEquals(network, result.values().iterator().next());
		assertEquals(network, service.getNetwork("test"));
	}

	@Test
	public void getNetworks_shouldHandleException() throws IOException, InterruptedException {
		Map<String, Network> networkMap = new HashMap<>();
		Network network = mock(Network.class);
		networkMap.put("test", network);
		doThrow(new RuntimeException("error")).when(service).loadNetworkMap();
		Map<String, Network> result = service.getNetworkMap();
		assertEquals(0, result.size());
	}

	@Test
	public void getProfileMap() throws IOException, InterruptedException {
		Map<String, Profile> profileMap = new HashMap<>();
		Profile profile = mock(Profile.class);
		profileMap.put("test", profile);
		doReturn(profileMap).when(service).getProfileMap();
		Map<String, Profile> result = service.getProfileMap();
		assertEquals(profile, result.values().iterator().next());
		assertEquals(profile, service.getProfile("test"));
	}

	@Test
	public void getProfileMap_shouldHandleException() throws IOException, InterruptedException {
		Map<String, Profile> profileMap = new HashMap<>();
		Profile profile = mock(Profile.class);
		profileMap.put("test", profile);
		doThrow(new RuntimeException("error")).when(service).loadProfileMap();
		Map<String, Profile> result = service.getProfileMap();
		assertEquals(0, result.size());
	}

	@Test
	public void getCertificateMap() throws IOException, InterruptedException {
		Map<String, Certificate> certificateMap = new HashMap<>();
		Certificate certificate = mock(Certificate.class);
		certificateMap.put("test", certificate);
		doReturn(certificateMap).when(service).getCertificateMap();
		Map<String, Certificate> result = service.getCertificateMap();
		assertEquals(certificate, result.values().iterator().next());
		assertEquals(certificate, service.getCertificate("test"));
	}

	@Test
	public void getCertificateMap_shouldHandleException() throws IOException, InterruptedException {
		Map<String, Certificate> certificateMap = new HashMap<>();
		Certificate certificate = mock(Certificate.class);
		certificateMap.put("test", certificate);
		doThrow(new RuntimeException("error")).when(service).loadCertificateMap();
		Map<String, Certificate> result = service.getCertificateMap();
		assertEquals(0, result.size());
	}
}
