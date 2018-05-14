package com.valuelabs.controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.bean.LoginDetailsBean;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.LoginDetails;
import com.valuelabs.service.HomePageService;
import com.valuelabs.service.HomePageServiceImpl;
import com.valuelabs.service.LoginService;
import com.valuelabs.service.LoginServiceImpl;

@Controller
@RequestMapping("/homepage")
public class HomePageController {
	@Autowired(required=true)
	HomePageService homePageService;
	@Autowired(required=true)
	LoginService loginService;
	
	@RequestMapping("/accountDetails")
	public @ResponseBody String accountDetails(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String accountDetails = "";
		String result;
		List list = loginService.checkUserAccountNumber(username, password);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			 accountDetails =   (String) it.next();
		}
		List accountDetailslist = homePageService.checkAccountDetails(accountDetails);
		if(!accountDetailslist.isEmpty()){
			result = "passed";
		}else{
			result = "failed";
		}
		return result;
	}

	@RequestMapping("/showdetails")
	public @ResponseBody List showDetails(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String accountDetails= "";
		List list = loginService.checkUserAccountNumber(username, password);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			 accountDetails =   (String) it.next();
		}
		List<AccountDetails> accountDetailslist = homePageService.checkAccountDetails(accountDetails);
				Iterator<AccountDetails> accountDetailsList = accountDetailslist.iterator();
			AccountDetails accountDetail = (AccountDetails) accountDetailsList.next();
			/*System.out.println(( accountDetail).getAccNumber());
			System.out.println(( accountDetail).getAccName());
			System.out.println(( accountDetail).getTotalAmount());*/
		return accountDetailslist;
	}
	
}
