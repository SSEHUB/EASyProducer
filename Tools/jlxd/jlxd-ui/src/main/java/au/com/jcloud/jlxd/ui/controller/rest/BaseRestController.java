package au.com.jcloud.jlxd.ui.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.jcloud.jlxd.ui.model.Server;
import au.com.jcloud.jlxd.ui.search.AjaxResponseBody;
import au.com.jcloud.jlxd.ui.search.SearchCriteria;
import au.com.jcloud.jlxd.ui.service.ServerService;
import au.com.jcloud.lxd.LxdConstants;
import au.com.jcloud.lxd.service.ICachingLxdService;
import au.com.jcloud.lxd.service.ILxdService;

public abstract class BaseRestController<T> {

	private static final Logger LOG = Logger.getLogger(ContainerRestController.class);

	@Autowired
	private ICachingLxdService lxdService;

	@Autowired
	private ServerService serverService;

	public ICachingLxdService getLxdService(HttpServletRequest request) {
		ICachingLxdService lxdService = this.lxdService;
		Server lxdServer = serverService.getServerFromSession(request);
		if (lxdServer != null) {
			lxdService = lxdServer.getLxdService();
		}
		return lxdService;
	}

	@PostMapping("/reload")
	public ResponseEntity<?> reloadEntity(HttpServletRequest request, Class<T> classType) {
		AjaxResponseBody<T> result = new AjaxResponseBody<>();
		try {
			if (!isDefaultServerAndWindowsOs(lxdService)) {
				getLxdService(request).reloadContainerCache();
			}
			Collection<T> entities = getEntities(getLxdService(request)).values();
			result.setResult(entities);
			if (classType == null && entities != null && !entities.isEmpty()) {
				T entity = entities.iterator().next();
				if (entity != null) {
					classType = (Class<T>) entity.getClass();
				}
			}
			result.setMsg((classType != null ? classType.getSimpleName() : StringUtils.EMPTY) + " reloaded");
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/view/{name}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> viewEntity(HttpServletRequest request, @PathVariable String name) {
		try {
			T entity = getEntity(getLxdService(request), name);
			if (entity == null) {
				throw new Exception(name + " could not be found");
			}
			return ResponseEntity.ok(entity);
		} catch (Exception e) {
			LOG.error(e, e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/search/{searchTerm}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> searchEntity(HttpServletRequest request, @PathVariable String searchTerm) {
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setSearchTerm(searchTerm);
		return searchEntity(request, searchCriteria, null);
	}

	@PostMapping("/search")
	public ResponseEntity<?> searchEntity(HttpServletRequest request,
			@Valid @RequestBody SearchCriteria search, Errors errors) {

		AjaxResponseBody<T> result = new AjaxResponseBody<>();

		//If error, just return a 400 bad request, along with the error message
		if (errors != null && errors.hasErrors()) {
			result.setMsg(StringUtils.join(errors.getAllErrors(), ","));
			return ResponseEntity.badRequest().body(result);
		}

		try {
			Map<String, T> entities = getEntities(request);

			String searchTerm = search.getSearchTerm().trim();
			if (entities.isEmpty()) {
				result.setMsg("No search results found!");
				result.setResult(entities.values());
			}
			else if (StringUtils.isEmpty(searchTerm)) {
				result.setMsg("Showing all search results!");
				result.setResult(entities.values());
			}
			else {
				result.setResult(new ArrayList<T>());
				performSearch(entities, search, result);
			}
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
		}

		return ResponseEntity.ok(result);
	}

	protected boolean isDefaultServerAndWindowsOs(ILxdService lxdService) {
		return LxdConstants.IS_WINDOWS && (lxdService.getLxdServerCredential() == null || StringUtils.isEmpty(lxdService.getLxdServerCredential().getRemoteHostAndPort()));
	}

	public abstract T getEntity(ICachingLxdService lxdService, String name) throws IOException, InterruptedException;

	public abstract Map<String, T> getEntities(ICachingLxdService lxdService) throws IOException, InterruptedException;

	public void performSearch(Map<String, T> entities, SearchCriteria search, AjaxResponseBody<T> result) throws Exception {
		String searchTerm = search.getSearchTerm().trim();
		for (String name : entities.keySet()) {
			T entity = entities.get(name);
			if (name.toLowerCase().contains(searchTerm.toLowerCase())) {
				result.getResult().add(entity);
			}
		}
		if (result.getResult().size() > 0) {
			result.setMsg("success. found " + result.getResult().size() + " results for search term: " + searchTerm);
		}
		else {
			throw new Exception("No results found for search term: " + searchTerm);
		}
	}

	public Map<String, T> getEntities(HttpServletRequest request) throws IOException, InterruptedException {
		return getEntities(getLxdService(request));
	}

	public ICachingLxdService getLxdService() {
		return lxdService;
	}

	public void setLxdService(ICachingLxdService lxdService) {
		this.lxdService = lxdService;
	}

	public ServerService getServerService() {
		return serverService;
	}

	public void setServerService(ServerService serverService) {
		this.serverService = serverService;
	}
}
