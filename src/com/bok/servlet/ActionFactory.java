package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){
			
		case "SprtUIAction":
			a = new SprtUIAction();
			break;
			
		case "BfSprtUIAction":
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
			
		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
