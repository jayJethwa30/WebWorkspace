package com.lti.service;

import java.util.List;

import com.lti.bean.Account;
import com.lti.dao.AccountDAO;
import com.lti.dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {

	private AccountDAO dao=new AccountDAOImpl();
	
	@Override
	public boolean createNewAccount(Account ob) {
		// TODO Auto-generated method stub
		return dao.insertAccount(ob);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return dao.getAllAccount();
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(ob);
	}

	@Override
	public boolean withdraw(Account ob, double amount) {
		// TODO Auto-generated method stub
		double originalbalance=ob.getBalance();
		originalbalance=originalbalance-amount;
		ob.setBalance(originalbalance);
		return dao.updateAccount(ob);
	}

	@Override
	public Account getMyAccount(int accno) {
		// TODO Auto-generated method stub
		return dao.getAccountById(accno);
	}
	

}
