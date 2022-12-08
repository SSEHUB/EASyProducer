package au.com.jcloud.jlxd.ui.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import au.com.jcloud.jlxd.ui.bean.AddContainerInput;
import au.com.jcloud.jlxd.ui.model.Server;
import au.com.jcloud.jlxd.ui.search.AjaxResponseBody;
import au.com.jcloud.lxd.bean.ImageConfig;
import au.com.jcloud.lxd.enums.ContainerStateAction;
import au.com.jcloud.lxd.model.Container;
import au.com.jcloud.lxd.model.State;
import au.com.jcloud.lxd.model.StatusCode;
import au.com.jcloud.lxd.model.extra.NetworkInterface;
import au.com.jcloud.lxd.service.ICachingLxdService;

@RequestMapping("/container")
@RestController
public class ContainerRestController extends BaseRestController<Container> {

	private static final Logger LOG = Logger.getLogger(ContainerRestController.class);

	@RequestMapping(value = "/reload/state/{name}", method = { RequestMethod.GET, RequestMethod.POST })
	public String reloadState(HttpServletRequest request, @PathVariable String name) {
		try {
			if (StringUtils.isBlank(name)) {
				throw new IllegalArgumentException("Cannot start container if containerName is blank");
			}
			ICachingLxdService lxdService = getLxdService(request);
			Container container = lxdService.getContainer(name);
			if (container == null) {
				throw new Exception("Could not find container with name: " + name);
			}
			State state = lxdService.loadContainerState(name);
			if (state == null) {
				throw new Exception("Could not find state for container with name: " + name);
			}
			container.setState(state);
			return state.getStatus();
		} catch (Exception e) {
			LOG.error(e, e);
			return e.getMessage();
		}
	}

	@Override
	public Container getEntity(ICachingLxdService lxdService, String name) {
		return lxdService.getContainer(name);
	}

	@Override
	public Map<String, Container> getEntities(ICachingLxdService lxdService) throws IOException, InterruptedException {
		Map<String, Container> containers = new HashMap<>();
		if (isDefaultServerAndWindowsOs(lxdService)) {
			Container c = new Container();
			c.setName("david");
			c.setStatus("Running");
			c.setStatusCode(StatusCode.RUNNING.getValue());
			State s = new State();
			s.setStatusCode(State.STATUS_CODE_RUNNING);
			s.setPid(123);
			Map<String, NetworkInterface> networkMap = new HashMap<>();
			NetworkInterface netIf = new NetworkInterface();
			Gson gson = new Gson();
			Map<String, String> address = gson.fromJson("{\"family\":\"inet\",\"address\":\"10.1.1.23\",\"netmask\":\"24\",\"scope\":\"global\"}", Map.class);
			netIf.setAddresses(new Map[] { address });
			networkMap.put("eth0", netIf);
			s.setNetwork(networkMap);
			c.setState(s);
			c.setArchitecture("x64");
			containers.put(c.getName(), c);

			Container c2 = new Container();
			c2.setName("test");
			c2.setStatus("Stopped");
			c2.setStatusCode(StatusCode.STOPPED.getValue());
			State s2 = new State();
			s2.setStatusCode(State.STATUS_CODE_STOPPED);
			s2.setPid(456);
			c2.setState(s2);
			c2.setArchitecture("win");
			containers.put(c2.getName(), c2);
		}
		else {
			containers = lxdService.getContainerMap();
		}
		return containers;
	}

	@RequestMapping(value = "/start/{containerName}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> startContainer(HttpServletRequest request, @PathVariable String containerName) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		try {
			if (StringUtils.isBlank(containerName)) {
				throw new IllegalArgumentException("Cannot start container if containerName is blank");
			}
			getLxdService(request).startContainer(containerName);
			result.setResult(getEntities(request).values());
			result.setMsg("container started: " + containerName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/stop/{containerName}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> stopContainer(HttpServletRequest request, @PathVariable String containerName) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		try {
			if (StringUtils.isBlank(containerName)) {
				throw new IllegalArgumentException("Cannot start container if containerName is blank");
			}
			getLxdService(request).stopContainer(containerName);
			result.setResult(getEntities(request).values());
			result.setMsg("container stopped: " + containerName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping(value = "/state/{containerName}/{action}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> changeContainerState(HttpServletRequest request, @PathVariable String containerName, @PathVariable String action) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		try {
			if (StringUtils.isBlank(containerName)) {
				throw new IllegalArgumentException("Cannot action container if containerName is blank");
			}
			if (StringUtils.isBlank(action)) {
				throw new IllegalArgumentException("Cannot action container if action is blank");
			}
			ContainerStateAction containerStateAction = ContainerStateAction.valueOf(action.toUpperCase());
			if (containerStateAction==null) {
				throw new IllegalArgumentException("Cannot action container as action="+action+" is not valid");
			}
			getLxdService(request).changeContainerState(containerName, containerStateAction, false, false, StringUtils.EMPTY);
			result.setResult(getEntities(request).values());
			result.setMsg("container stopped: " + containerName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createNewContainer(HttpServletRequest request,
			@Valid @RequestBody AddContainerInput addContainerInput, Errors errors) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		// If validation errors, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {
			result.setMsg(StringUtils.join(errors.getAllErrors(), ","));
			return ResponseEntity.badRequest().body(result);
		}

		try {
			String containerName = addContainerInput.getName();
			getLxdService(request).createContainer(addContainerInput.getName(), addContainerInput.getImageAlias(), addContainerInput);
			result.setResult(getEntities(request).values());
			result.setMsg("container created: " + containerName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/delete/{name}")
	public ResponseEntity<?> deleteContainer(HttpServletRequest request,
			@PathVariable String name) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		try {
			ICachingLxdService lxdService = getLxdService(request);
			Container container = lxdService.getContainer(name);
			if (container == null) {
				throw new Exception("Could not find container with name: " + name);
			}
			lxdService.deleteContainer(name);
			result.setResult(getEntities(request).values());
			result.setMsg("container deleted: " + name);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/rename/{name}/{newContainerName}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> renameContainer(HttpServletRequest request, @PathVariable String name,
			@PathVariable String newContainerName) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		try {
			if (StringUtils.isBlank(name)) {
				throw new IllegalArgumentException("Cannot have oldContainerName blank");
			}
			if (StringUtils.isBlank(newContainerName)) {
				throw new IllegalArgumentException("Cannot have newContainerName blank");
			}
			getLxdService(request).renameContainer(name, newContainerName);
			result.setResult(getEntities(request).values());
			result.setMsg("container renamed: " + name + "=>" + newContainerName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	// TODO: No longer used.
	@PostMapping("/create/{newContainerName}/{imageAlias}/{ephemeral}/{profile}/{config}")
	public ResponseEntity<?> createNewContainerByUrl(HttpServletRequest request, @PathVariable String newContainerName,
			@PathVariable String imageAlias, @PathVariable String ephemeral, @PathVariable String profile,
			@PathVariable String config) {

		AjaxResponseBody<Container> result = new AjaxResponseBody<>();

		try {
			if (StringUtils.isBlank(newContainerName)) {
				throw new IllegalArgumentException("Cannot create new container if newContainerName is blank");
			}
			if (StringUtils.isBlank(imageAlias)) {
				throw new IllegalArgumentException("Cannot create new container if imageName is blank");
			}
			ICachingLxdService lxdService = getLxdService(request);
			Boolean ephemeralValue = null;
			if (StringUtils.isNotBlank(ephemeral)) {
				ephemeralValue = Boolean.valueOf(ephemeral);
			}
			String architecture = null;
			List<String> profilesList = Arrays.asList(profile.split(","));
			ImageConfig imageConfig = new ImageConfig(ephemeralValue, architecture, profilesList, config);
			lxdService.createContainer(newContainerName, imageAlias, imageConfig);
			Container container = lxdService.getContainer(newContainerName);
			if (container == null) {
				throw new Exception("Could not get newly created container. " + newContainerName);
			}
			result.setMsg("container created: " + container.getName());
			result.setResult(getEntities(request).values());
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	private ResponseEntity<?> oldSearch(HttpServletRequest request, @PathVariable String searchTerm) {
		AjaxResponseBody<Container> result = new AjaxResponseBody<>();
		int containersFound = 0;

		// Get all servers
		Map<String, Server> serverMap = getServerService().getServerMap(request);
		Server serverInRequest = getServerService().getServerFromSession(request);
		Collection<Server> serversToSearch = new ArrayList<>();
		if (serverInRequest != null) {
			serversToSearch.add(serverInRequest);
		}
		else {
			serversToSearch.addAll(serverMap.values());
		}

		Collection<Container> resultContainers = new ArrayList<>();
		StringBuilder serverString = new StringBuilder();
		for (Server server : serversToSearch) {
			try {
				List<Container> containers = findContainersForLxdService(server.getLxdService(), searchTerm);
				containersFound += containers.size();
				LOG.debug("Fonund " + containers.size() + " containers with name: " + searchTerm);
				server.setContainers(containers);
				resultContainers.addAll(containers);
				if (serverString.length() > 0) {
					serverString.append(",");
				}
				serverString.append(server.getName());
			} catch (Exception e) {
				LOG.error(e, e);
				result.setMsg(e.getMessage());
				return ResponseEntity.badRequest().body(result);
			}
		}

		result.setResult(resultContainers);
		result.setMsg("success. found " + containersFound + " conatiners in server(s) " + serverString + " for searchTerm: " + searchTerm);

		return ResponseEntity.ok(result);
	}

	private List<Container> findContainersForLxdService(ICachingLxdService lxdService, String searchTerm) throws IOException, InterruptedException {
		List<Container> result = new ArrayList<>();
		Map<String, Container> containers = getEntities(lxdService);
		if (containers.isEmpty()) {
			return result;
		}
		else if (StringUtils.isEmpty(searchTerm)) {
			result.addAll(containers.values());
		}
		else if (containers.containsKey(searchTerm)) {
			result.add(containers.get(searchTerm));
		}
		return result;
	}

}
