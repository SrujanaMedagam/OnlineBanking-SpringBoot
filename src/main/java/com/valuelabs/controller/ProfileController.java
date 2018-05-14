package com.valuelabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.service.LoginService;
import com.valuelabs.service.LoginServiceImpl;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired(required=true)
	LoginService loginService;
	
	public @ResponseBody String myProfileAccountNumber(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String result;
		if (loginService.isAccountNumber(username, password)) {
			result = "passed";
		} else {
			result = "failed";
		}
		return result;
	}

	@RequestMapping("/myProfile")
	public @ResponseBody List myProfileUpdate(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String result;
		String accountNumber = loginService.getAccountNumber(username, password);
		List list = loginService.getProfileData(accountNumber);

		return list;
	}

	@RequestMapping("/update")
	public @ResponseBody String ProfileUpdate(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("address") String address,
			@RequestParam("emailId") String emailId, @RequestParam("phoneNumber") int phoneNumber,
			@RequestParam("panNumber") String panNumber, @RequestParam("aadharNumber") int aadharNumber) {
		String result;
		String accountNumber = loginService.getAccountNumber(username, password);
		if (loginService.getProfileUpdate(accountNumber, address, emailId, phoneNumber, panNumber, aadharNumber)) {

			result = "passed";
		} else {

			result = "failed";
		}
		return result;
	}
}
