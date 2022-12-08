package au.com.jcloud.jlxd.ui.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.jcloud.jlxd.ui.search.AjaxResponseBody;
import au.com.jcloud.lxd.model.Image;
import au.com.jcloud.lxd.model.ImageAlias;
import au.com.jcloud.lxd.service.ICachingLxdService;

@RequestMapping("/image")
@RestController
public class ImageRestController extends BaseRestController<Image> {

	private static final Logger LOG = Logger.getLogger(ImageRestController.class);

	@Override
	public Map<String, Image> getEntities(ICachingLxdService lxdService) throws IOException, InterruptedException {
		Map<String, Image> images = new HashMap<>();
		if (isDefaultServerAndWindowsOs(lxdService)) {
			Image image = new Image();
			image.setFingerprint("123");
			image.setArchitecture("x64");
			image.setDescription("ubuntu");
			List<ImageAlias> aliases = new ArrayList<>();
			aliases.add(new ImageAlias().name("alias1"));
			aliases.add(new ImageAlias().name("alias2"));
			image.setAliases(aliases);
			images.put(image.getFingerprint(), image);

			Image image2 = new Image();
			image2.setFingerprint("456");
			image2.setArchitecture("x32");
			image2.setDescription("windows");
			images.put(image2.getFingerprint(), image2);
		}
		else {
			images = getLxdService().getImageMap();
		}
		return images;
	}

	@Override
	public Image getEntity(ICachingLxdService lxdService, String name) {
		return lxdService.getImage(name);
	}

	@PostMapping("/alias/create/{aliasName}/{imageFingerprint}")
	public ResponseEntity<?> createImageAlias(HttpServletRequest request, @PathVariable String aliasName,
			@PathVariable String imageFingerprint) {
		AjaxResponseBody<Image> result = new AjaxResponseBody<>();

		try {
			ICachingLxdService lxdService = getLxdService(request);
			Image image = lxdService.getImage(imageFingerprint);
			if (image == null) {
				throw new Exception("Could not find image with fingerprint : " + imageFingerprint);
			}
			ImageAlias alias = lxdService.getImageAlias(aliasName);
			if (alias != null) {
				if (alias.getTarget().equals(image.getFingerprint())) {
					throw new Exception("Alias " + aliasName + " already assigned to " + imageFingerprint);
				}
				else {
					throw new Exception("Alias " + aliasName + " already assigned to " + alias.getTarget());
				}
			}
			lxdService.createImageAlias(aliasName, imageFingerprint);
			ImageAlias newImageAlias = lxdService.getImageAlias(aliasName);
			if (newImageAlias == null) {
				throw new Exception("Could not create image alias: " + aliasName);
			}

			result.setResult(getEntities(request).values());
			result.setMsg("New alias " + aliasName + " assigned to image: " + imageFingerprint);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/alias/delete/{aliasName}")
	public ResponseEntity<?> deleteImageAlias(HttpServletRequest request, @PathVariable String aliasName) {
		AjaxResponseBody<Image> result = new AjaxResponseBody<>();

		try {
			ICachingLxdService lxdService = getLxdService(request);
			ImageAlias alias = lxdService.getImageAlias(aliasName);
			if (alias == null) {
				throw new Exception("Alias " + aliasName + " does not exist");
			}
			lxdService.deleteImageAlias(aliasName);

			result.setResult(getEntities(request).values());
			result.setMsg("Deleted alias " + aliasName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/alias/rename/{aliasName}/{newAliasName}")
	public ResponseEntity<?> renameImageAlias(HttpServletRequest request, @PathVariable String aliasName,
			@PathVariable String newAliasName) {
		AjaxResponseBody<Image> result = new AjaxResponseBody<>();

		try {
			ICachingLxdService lxdService = getLxdService(request);
			ImageAlias alias = lxdService.getImageAlias(aliasName);
			if (alias == null) {
				throw new Exception("Alias " + aliasName + " does not exist");
			}
			ImageAlias newAlias = lxdService.getImageAlias(newAliasName);
			if (newAlias != null) {
				throw new Exception("New Image Alias " + newAliasName + " already exists");
			}
			lxdService.renameImageAlias(aliasName, newAliasName);

			result.setResult(getEntities(request).values());
			result.setMsg("Renamed alias " + aliasName + " to " + newAliasName);
		} catch (Exception e) {
			LOG.error(e, e);
			result.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
}
