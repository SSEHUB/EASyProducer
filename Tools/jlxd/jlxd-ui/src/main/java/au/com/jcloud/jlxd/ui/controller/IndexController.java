package au.com.jcloud.jlxd.ui.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private final Logger LOG = Logger.getLogger(IndexController.class);

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/container")
	public String container() {
		return "container";
	}

	@GetMapping("/image")
	public String image() {
		return "image";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

	@GetMapping("/server")
	public String server() {
		return "server";
	}

}