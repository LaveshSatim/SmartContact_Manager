package com.smart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.entities.User;
import com.smart.exception.Msg;
import com.smart.repository.UserRepository;

@Controller
public class HomeController implements ErrorController {

	public HomeController(UserRepository repository) {
		super();
		this.repository = repository;
	}

	private final UserRepository repository;

	@RequestMapping("/home")
	public String getHomePage(Model model) {
		model.addAttribute("name", "smart contact manager");
		return "home";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("name", "Signup");
		model.addAttribute("user", new User());
		return "signup";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("name", "Login");
		return "login";
	}

	@RequestMapping("/about")
	public String getAboutPage(Model model) {
		model.addAttribute("name", "about us");
		return "about";
	}

	// error handler
	@RequestMapping("/error")
	public String errorPage() {
		return "errorpage";
	}

	@PostMapping("do_register")
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result,
			@RequestParam(value = "agreement", defaultValue = "false") boolean check, Model model,
			HttpSession session) {

		try {
			if (!check) {
				throw new RuntimeException("please accept t and c");
			}

			if (result.hasErrors()) {
				System.out.println("ERROR /-*/-*/-/-/" + result.toString());
				model.addAttribute("user", user);
				return "signup";

			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			// System.out.println("*******" +
			// this.repository.existsByEmail(user.getEmail()));

			if (this.repository.existsByEmail(user.getEmail())) {
				throw new RuntimeException("existing user please login");
			}

			this.repository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Msg("successfully register", "alert-success"));
			return "signup";
		} catch (Exception e) {

			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Msg(e.getMessage(), "alert-danger"));
			return "signup";
		}

	}
}