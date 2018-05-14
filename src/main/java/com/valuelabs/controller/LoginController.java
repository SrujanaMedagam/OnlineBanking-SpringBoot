package com.valuelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired(required=true)
	LoginService loginService;

	@RequestMapping("/")
	public String homepage() {
		System.out.println("Srujana");
		return "login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public @ResponseBody String checkLoginCredentials(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		String result;
		if (loginService.checkUserLoginCredentials(username, password)) {
			result = "passed";
		} else {
			result = "failed";
		}
		return result;
	}
	
	@RequestMapping(value = "/checkAccountNumber", method = RequestMethod.GET)
	public @ResponseBody String checkAccountNumber(@RequestParam("accountNumber") String accountNumber) {
		String result;
		if (loginService.checkIsAccountNumber(accountNumber)) {
			result = "passed";
		} else {
			result = "failed";
		}
		return result;
	}

	@RequestMapping(value = "/checkUserID", method = RequestMethod.GET)
	public @ResponseBody String checkUserID(@RequestParam("username") String username) {
		String result;
		if (loginService.checkUserId(username)) {
			result = "passed";
		} else {
			result = "failed";
		}
		return result;
	}
	@RequestMapping(value = "/accountNumber", method = RequestMethod.GET)
	public @ResponseBody String getAccountNumber(@RequestParam("username") String username, @RequestParam("password") String password) {
		String accountNumber = loginService.getAccountNumber(username, password);
		return accountNumber;
	}
	
	@RequestMapping("/newUserPermission")
	public @ResponseBody String newUserAccessPermission(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("accountName") String accountName, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("address") String address,
			@RequestParam("emailId") String emailId, @RequestParam("phoneNumber") int phoneNumber,
			@RequestParam("panNumber") String panNumber, @RequestParam("aadharNumber") int aadharNumber,
			@RequestParam("accountType") String accountType, @RequestParam("date") String date) {
		System.out.println("newUserAccessPermission");
		System.out.println("newUserAccessPermission");
		if (loginService.newUserPermission(accountNumber, accountName, username, password, address, emailId,
				phoneNumber, panNumber, aadharNumber, accountType, date)) {
			return "passed";
		}
		return "failed";
	}
}
