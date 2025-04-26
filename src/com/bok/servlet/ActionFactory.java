package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){

		case "loginUI":
			a = new loginUIAction();
			break;
			
		case "sprtUI":
			a = new SprtUIAction();
			break;
			
		case "bfSprtUI":
			a = new BfSprtUIAction();
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
  
