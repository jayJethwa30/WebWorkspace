package com.lti.service;

import com.lti.bean.Account;
import java.util.List;

public interface AccountService {

	public boolean createNewAccount(Account ob);
	public List<Account> getAllAccounts();
	public boolean deleteAccount(Account ob);
	public boolean withdraw(Account ob, double amount);
	public Account getMyAccount(int accno);
	
}
