package au.com.jcloud.jlxd.ui.controller.rest;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import au.com.jcloud.jlxd.ui.bean.AddServerInput;
import au.com.jcloud.jlxd.ui.model.Server;
import au.com.jcloud.jlxd.ui.search.AjaxResponseBody;
import au.com.jcloud.jlxd.ui.service.ServerService;
import au.com.jcloud.lxd.model.ServerInfo;
import au.com.jcloud.lxd.service.ICachingLxdService;

@RequestMapping("/server")
@RestController
public class ServerRestController extends BaseRestController<ServerInfo> {

	public static final Logger LOG = Logger.getLogger(ServerRestController.class);

	@Autowired
	private ServerService serverService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> listServers(HttpServletRequest request) {
		AjaxResponseBody<Server> result = new AjaxResponseBody<>();
		try {
			Collection<Server> servers = serverService.getServerMap(request).values();
			result.setResult(servers);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("/{name}")
	public ResponseEntity<?> selectServer(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable String name) throws IOException, ServletException {
		AjaxResponseBody<Server> result = new AjaxResponseBody<>();

		Server currentServer = serverService.getServerFromSession(request);
		// Get all registered servers
		Map<String, Server> serverMap = serverService.getServerMap(request);
		// find lxdService from id;
		if (serverMap.containsKey(name)) {
			Server server = serverMap.get(name);
			if (currentServer != null) {
				currentServer.setActive(false);
			}
			serverService.setServerInSession(request, server);

			Collection<Server> servers = serverService.getServerMap(request).values();
			result.setResult(servers);
			return ResponseEntity.ok(result);
		}
		else {
			String errorMessage = "Could not find server with name: " + name;
			LOG.warn(errorMessage);
			result.setMsg(errorMessage);
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> addServer(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestBody AddServerInput addServerInput, Errors errors)
			throws IOException, ServletException, CloneNotSupportedException, InterruptedException {
		AjaxResponseBody<ServerInfo> result = new AjaxResponseBody<>();

		Map<String, Server> serverMap = serverService.getServerMap(request);
		String name = addServerInput.getName();
		if (serverMap.containsKey(name)) {
			throw new ServletException("The server with name: " + name + " already exists");
		}
		String remoteHostAndPort = addServerInput.getHostAndPort();
		for (Server server : serverMap.values()) {
			if (remoteHostAndPort.equalsIgnoreCase(server.getRemoteHostAndPort())) {
				throw new ServletException("The server with remoteHostAndPort: " + remoteHostAndPort + " already exists");
			}
		}
		String description = addServerInput.getDescription();

		// TODO: How to upload these
		String remoteCert = addServerInput.getRemoteCert();
		String remoteKey = addServerInput.getRemoteKey();
		Server server = serverService.createNewServer(name, description, remoteHostAndPort, remoteCert, remoteKey);
		if (server == null) {
			throw new ServletException("Failed to create server with name: " + name);
		}
		serverMap.put(server.getName(), server);

		// Set the active server as the newly added server
		Server currentServer = serverService.getServerFromSession(request);
		currentServer.setActive(false);
		server.setActive(true);

		result.setResult(getEntities(request).values());
		return ResponseEntity.ok(result);
	}

	@PostMapping("/delete/{name}")
	public ResponseEntity<?> deleteServer(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable String name) throws IOException, ServletException, InterruptedException {
		AjaxResponseBody<ServerInfo> result = new AjaxResponseBody<>();

		Server currentServer = serverService.getServerFromSession(request);
		Map<String, Server> serverMap = serverService.getServerMap(request);
		if (serverMap.containsKey(name)) {
			Server serverRemoved = serverMap.remove(name);
			if (currentServer != null && currentServer.equals(serverRemoved)) {
				if (!serverMap.isEmpty()) {
					currentServer = serverMap.values().iterator().next();
					serverService.setServerInSession(request, currentServer);
				}
			}
		}

		result.setResult(getEntities(request).values());
		return ResponseEntity.ok(result);
	}

	@Override
	public void setServerService(ServerService serverService) {
		this.serverService = serverService;
	}

	@Override
	public ServerInfo getEntity(ICachingLxdService lxdService, String name) throws IOException, InterruptedException {
		Gson gson = new Gson();
		ServerInfo serverInfo;
		if (isDefaultServerAndWindowsOs(lxdService)) {
			Resource resource = new ClassPathResource("/static/json/serverinfo.json");
			Reader reader = null;
			try {
				try {
					reader = new FileReader(resource.getFile());
				} catch (Exception e) {
					reader = new InputStreamReader(resource.getInputStream());
				}
				serverInfo = gson.fromJson(reader, ServerInfo.class);
				serverInfo.getEnvironment().setKernel(System.getProperty("os.name"));
				serverInfo.getEnvironment().setKernelVersion(System.getProperty("os.version"));
				serverInfo.getEnvironment().setKernelArchitecture(System.getProperty("os.arch"));
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		}
		else {
			serverInfo = lxdService.loadServerInfo();
		}
		if (serverInfo != null) {
			serverInfo.setName(name);
		}
		return serverInfo;
	}

	@Override
	public Map<String, ServerInfo> getEntities(HttpServletRequest request) throws IOException, InterruptedException {
		Map<String, Server> servers = serverService.getServerMap(request);
		Map<String, ServerInfo> results = new HashMap<>();
		for (String serverName : servers.keySet()) {
			Server server = servers.get(serverName);
			ServerInfo serverInfo = getEntity(server.getLxdService(), serverName);
			if (serverInfo != null) {
				results.put(serverName, serverInfo);
			}
		}
		return results;
	}

	@Override
	public Map<String, ServerInfo> getEntities(ICachingLxdService lxdService) throws IOException, InterruptedException {
		throw new IOException("getEntities() method not supported");
	}
}
