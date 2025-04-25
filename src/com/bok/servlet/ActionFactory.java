package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){

		case "loginUI":
			a = new loginUIAction();
			break;
			
		case "SprtUIAction":
			a = new SprtUIAction();
			break;
			
		case "BfSprtUIAction":
			a = new BfSprtUIAction();
			break;
			
		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
