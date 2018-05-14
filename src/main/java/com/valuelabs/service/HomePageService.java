package com.valuelabs.service;

import java.util.List;

public interface HomePageService {
	public List checkUserLoginCredentials(String username, String password);
	public List checkAccountDetails(String accountDetails);

}
