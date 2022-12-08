package au.com.jcloud.jlxd.ui.controller.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.jcloud.lxd.model.Profile;
import au.com.jcloud.lxd.service.ICachingLxdService;

@RequestMapping("/profile")
@RestController
public class ProfileRestController extends BaseRestController<Profile> {

	private static final Logger LOG = Logger.getLogger(ProfileRestController.class);

	@Override
	public Map<String, Profile> getEntities(ICachingLxdService lxdService) throws IOException, InterruptedException {
		Map<String, Profile> profiles = new HashMap<>();
		if (!isDefaultServerAndWindowsOs(lxdService)) {
			profiles = lxdService.getProfileMap();
		}

		return profiles;
	}

	@Override
	public Profile getEntity(ICachingLxdService lxdService, String name) {
		return lxdService.getProfile(name);
	}
}
