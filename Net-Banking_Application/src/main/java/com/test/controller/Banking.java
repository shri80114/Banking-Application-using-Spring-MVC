package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.beans.CreateAccount;
import com.test.service.CheckingService;
import com.test.service.Statements;

@Controller
@RequestMapping("/")
public class Banking {
	@Autowired
	CheckingService check;

	@Autowired
	Statements statements;

	@RequestMapping("/")
	public String login() {
		System.out.println("Login page executed");
		return "login";
	}

	@GetMapping("/deposit")
	public String balance() {
		return "deposit";
	}

	public String balanceShow(@RequestParam("amount") String string) {
		double bal = Double.parseDouble(string);
		ModelAndView model = new ModelAndView();
		model.addObject(bal);
		System.out.println(bal);
		return "balance";
	}

	@PostMapping("/login")
	public ModelAndView loginPage(HttpServletRequest request) {

		System.out.println(request.getParameter("userName"));
		System.out.println(request.getParameter("password"));
		String email = request.getParameter("userName");
		String pass = request.getParameter("password");

		ModelAndView model = new ModelAndView();
		List<CreateAccount> list = check.checking(email, pass);
		String firstName = null;
		String emailId = null;
		String password = null;
		Integer Acc=0;

		for (CreateAccount acc : list) {
			emailId = acc.getEmail();
			password = acc.getPassword();
			firstName = acc.getFirstName() + " " + acc.getLastName();
			Acc= acc.getAccountNumber();
		}

		if (emailId.equalsIgnoreCase(email) && password.equalsIgnoreCase(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", emailId);
			session.setAttribute("firstName", firstName);
			session.setAttribute("Acc", Acc);
		
			model.setViewName("main");

		} else {
			model.setViewName("login");
			model.addObject("wrong", "Incorrect Password");
			System.out.println("Incorrect Password");
		}
		return model;
	}

	@RequestMapping(path="/MiniStatement",method = RequestMethod.POST )
	public String miniStatement() {
//		System.out.println(request.getParameter("trip-start"));
//		System.out.println(request.getParameter("trip-end"));
//		List<TransactionTable> list = statements.getMiniStatement(request.getParameter("trip-start"), request.getParameter("trip-end"));
//		for (TransactionTable t : list) {
//			System.out.println(t.getTransId() + " " + t.getTransDate() + " " + t.getAmount() + " " + t.getAccNo());
//		}
		return "MiniStatement";
	}

}
