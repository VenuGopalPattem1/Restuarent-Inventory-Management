package com.example.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.loginCredentials.AdminLogin;
import com.example.demo.service.ProductServices;
import com.example.demo.service.UserServices;

@Controller
public class HomeController 
{
	@Autowired
	private ProductServices productServices;
	@Autowired
	private UserServices userService;
	@GetMapping("/home")
	public String home()
	{
		
		return "Home";
	}

	@GetMapping("/products")
	public String products( Model model)
	{ 
		List<Product> allProducts = this.productServices.getAllProducts();
		model.addAttribute("products", allProducts);
		return "Products";
	}

	@GetMapping("/location")
	public String location()
	{
		return "Locate_us";
	}

	@GetMapping("/about")
	public String about()
	{
		return "About";
	}

	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("adminLogin",new AdminLogin());
		return "Login";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute User reg)
	{
		return "reg";
	}
	@PostMapping("/register")
	public String register1(@ModelAttribute User reg,RedirectAttributes att)
	{
		userService.addUser(reg);
		return "redirect:login";
	}
}