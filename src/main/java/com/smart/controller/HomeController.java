package com.smart.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController implements ErrorController {

	@RequestMapping("/home")
	public String getHomePage(Model model) {
		model.addAttribute("name", "smart contact manager");
		return "home";
	}

	// error handler
	@RequestMapping("/error")
	public String errorPage() {
		return "errorpage";
	}

}
