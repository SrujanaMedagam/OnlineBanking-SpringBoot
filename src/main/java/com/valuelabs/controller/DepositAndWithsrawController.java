package com.valuelabs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.service.DepositAndWithdrawService;


@Controller
@RequestMapping("/amount")
public class DepositAndWithsrawController {
	@Autowired(required=true)
	DepositAndWithdrawService depositAndWithdrawService;
	//DepositAndWithdrawDaoImpl depositAndWithdrawDaoImpl;
	@RequestMapping("/deposit")	
	public @ResponseBody String depositAmount(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("amount") Double amount, @RequestParam("transactionDate") String transactionDate,@RequestParam("remarks") String remarks){
		
		String accNumber = depositAndWithdrawService.depositAmount(accountNumber);
		String result="";
		String toAccount = "-";
		String transactionType="Credit";
		
		if(accNumber!=""){
			if(depositAndWithdrawService.depositAmount(accountNumber,amount)){
				double balanceAmount = depositAndWithdrawService.balanceAmountAfterDeposit(accountNumber);
				depositAndWithdrawService.depositAndWithdrawAmountToTransactionHistory(accountNumber,amount,transactionDate,transactionType,balanceAmount,toAccount,remarks);
				result = "passed";
			}else{
				result = "failed";
			}
		}
	return result;
}
	@RequestMapping("/withdraw")	
	public @ResponseBody String withdrawAmount(@RequestParam("accountNumber") String accountNumber,@RequestParam("amount") Double amount,@RequestParam("transactionDate") String transactionDate,
			@RequestParam("remarks") String remarks){
		String accNumber = accountNumber;
		String toAccount = "-";
		String list1 = depositAndWithdrawService.withdrawAmount(accountNumber);
		String result1="";
		String transactionType = "Debit";
		if(list1!=""){
			System.out.println("condition sucess");
			if(depositAndWithdrawService.withdrawAmount(accountNumber,amount)){
				double balanceAmount = depositAndWithdrawService.balanceAmountAfterWithdraw(accountNumber);
				depositAndWithdrawService.depositAndWithdrawAmountToTransactionHistory(accountNumber,amount,transactionDate,transactionType,balanceAmount,toAccount,remarks);
				result1 = "pass";
			}else{
				result1 = "failed";
			}
		}
		else{
			result1 = "failed";	
		}
	return result1;
}
}


