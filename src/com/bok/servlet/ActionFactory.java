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
			
//		case "sprtManagerUI":
//			a = new SprtManagerUIAction();
//			break;
//			
//		case "setSprtInfo": 
//			a = new SetSprtInfoAction();
//			break;
//		case "setSprtAdd":
//			a = new SetSprtAddAction();
//			break;
//		case "setSprtUpdate":
//			a = new SetSprtUpdateAction();
//			break;
//		case "setSprtDelete":
//			a = new SetSprtDeleteAction();
//			break;
		
		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
