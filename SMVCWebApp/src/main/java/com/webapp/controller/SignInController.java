package com.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.datamodel.SignInModel;
import com.webapp.datamodel.SignInModel2;

@Controller
public class SignInController {

	@RequestMapping(value = "signIn", method = RequestMethod.GET)
	public String doSignIn(Model model) {
		SignInModel signInModel = new SignInModel(); signInModel.setUsername("Girish-K");
		model.addAttribute("foo", signInModel);
		return "SignIn";
	}

	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public String verifySignIn(
			@Valid
			@ModelAttribute("foo") SignInModel2 signInModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return "SignIn";
		} else {
			return "redirect:MyVenderTool.html";
		}
	}
	
	@RequestMapping(value = "MyVenderTool", method = RequestMethod.GET)
	public String myVenderTool(Model model) {
		
		return "MyVenderTool";
	}
}