package com.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.datamodel.RegistrationModel;

@Controller
public class RegistrationController {

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String doRegistration(Model model) {
		RegistrationModel signInModel = new RegistrationModel(); 
		signInModel.setEmail("Your Email Address");
		model.addAttribute("register", signInModel);
		return "registration";
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String verifyRegistration(
			@Valid
			@ModelAttribute("register") RegistrationModel signInModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		} else {
			return "redirect:RegisterConfirm.html";
		}
	}
	
	@RequestMapping(value = "RegisterConfirm", method = RequestMethod.GET)
	public String myVenderTool(Model model) {
		
		return "registrationConf";
	}
}