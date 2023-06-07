package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.beans.CreateAccount;
import com.test.service.Balance;
import com.test.service.CheckingService;

@Controller
public class AccountDetails {

	@Autowired
	Balance bank;

	@Autowired
	CheckingService check;

	@GetMapping("/CheckBalance")
	public String checkBalance() {
		return "CheckBalance";
	}

	@PostMapping("/depositAmount")
	public ModelAndView depostAmount(@RequestParam("amount") String string) {

		// String string = request.getParameter("amount");
		System.out.println(string);
		bank.depositAmount(string);
		ModelAndView model = new ModelAndView();
		model.addObject(string);
		model.setViewName("depositAmount");
		return model;

	}

	@GetMapping("/AccountDetails")
	public String accDetails() {
		return "AccountDetails";
	}

	@GetMapping("/WithDrawalServlet")
	public String withdrawAmount() {
		return "withdraw";
	}

	@PostMapping("/withdrawAmount")
	public ModelAndView withdrawAmount(@RequestParam("amount") String amount) {
		System.out.println(amount);
		bank.withdrawAmount(amount);
		ModelAndView model = new ModelAndView();

		model.setViewName("withdrawAmount");
		model.addObject("amount", amount);
		return model;
	}

	@GetMapping("/createAccount")
	public String createAccount() {
		return "createAccount";
	}

	@PostMapping("/registration")
	public String registor(@ModelAttribute CreateAccount account) {

		System.out.println(account.getFirstName());
		check.newUser(account);
		return "registration";
	}

	@GetMapping("/bankingStatements")
	public String bankStatement() {
		return "bankingStatement";
	}
}
