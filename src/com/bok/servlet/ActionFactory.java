package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){
			
		case "sprtUI":
			a = new SprtUIAction();
			break;
			
		case "bfSprtUI":
			a = new BfSprtUIAction();
			break;
		
		case "loginUI":
			a = new LoginUIAction();
			break;
			
		case "login":
			a = new LoginAction();
			break;
			
		case "ckHomeManagerUI" :
			a = new CkHomeManagerUIAction();
			break;
			
		case "youthSprt":
			a = new YouthSprtAction();
			break;
			
		case "loanSprt":
			a = new LoanSprtAction();
			break;
			
		case "happySprt":
			a = new HappySprtAction();
			break;
			
		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
