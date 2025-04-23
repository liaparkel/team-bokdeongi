package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){
//		case "idCheckAction":
//			a = new IdCheckAction();
//			break;
		
		case "loginUI" :
			a = new loginUIAction();
			break;
		
		
		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
