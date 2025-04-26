package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){
			
//		case "sprtUI":
//			a = new SprtUIAction();
//			break;
//			
//		case "bfSprtUI":
//			a = new BfSprtUIAction();
//			break;
		
		case "loginUI":
			a = new LoginUIAction();
			break;
			
		case "login":
			a = new LoginAction();
			break;
			
		case "ckHomeManagerUI" :
			a = new CkHomeManagerUIAction();
			break;
			
		case "getSprtCategory":
			a = new GetSprtCategoryAction();
			break;
			
		case "getSprtPerson":
			a = new GetSprtPersonAction();
			break;
			
		case "getSprtContent":
			a = new GetSprtContentAction();
			break;
			
		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
