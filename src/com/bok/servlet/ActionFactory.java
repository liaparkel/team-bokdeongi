package com.bok.servlet;


public class ActionFactory {
	private ActionFactory(){}
	public static Action getAction(String cmd){
		Action a;
		switch (cmd){

		case "loginUI":
			a = new LoginUIAction();
			break;
			
		case "ckHomeManagerUI":
			a = new CkHomeManagerUIAction();
			break;
			
		case "ckHomeUi":
			a = new CkHomeUIAction();
			break;
			
		case "ckContract":
			a = new CkContactAction();
			break;
			
		case "ckMovin":
			a = new CkMovinAction();
			break;
			
		case "ckRecontract":
			a = new CkRecontractAction();
			break;
			
		case "ckDownload":
			a = new CkDownloadAction();
			break;
			
		case "setHomeManager":
			a = new SetHomeManagerAction();
			break;
			
		case "setCkAdd":
			a = new SetCkAddAction();
			break;
			
		case "setCkSave":
			a = new SetCkSaveAction();
			break;
			
		case "setCkDelet":
			a = new SetCkDeletAction();
			break;
			
		case "setCkContent":
			a = new SetCkContentAction();
			break;
			
		case "ckContentDelete":
			a = new CkContentDeleteAction();
			break;
					
		case "addCk":
			a = new AddCkAction();
			break;
			
		case "addCkSave":
			a = new AddCkSaveAction();
			break;
			
		case "addCkCancel":
			a = new AddCkCencelAction();
			break;
			
		case "addTextAction":
			a = new AddCkCancelAction();
			break;
			
		case "ckBfManagerUI":
			a = new CkBfManagerUIAction();
			break;
			
		case "ckCategory":
			a = new CkCategoryAction();
			break;
			
		case "ckBfContentDelete":
			a = new CkBfContentDeleteAction();
			break;

		case "ckHomeUI" :
			a = new CkHomeUIAction();
			break;
					
		case "sprtUI":
			a = new SprtUIAction();
			break;
			
		case "bfSprtUI":
			a = new BfSprtUIAction();
			break;
			
		case "login":
			a = new LoginAction();
			break;
			
		case "getSprtCategory":
			a = new GetSprtCategoryAction();
			break;

		case "askUI" :
			a = new AskUIAction();
			break;
			
		case "soloAskUI" :
			a = new SoloAskUIAction();
			break;
			
		case "getSprtPerson":
			a = new GetSprtPersonAction();
			break;
		
		case "getBfSprtPerson":
			a = new GetBfSprtPersonAction();
			break;
			
		case "getSprtContent":
			a = new GetSprtContentAction();
			break;
		
		case "getBfSprtManagerPerson":
		    a = new GetBfSprtManagerPersonAction();
		    break;

		case "sprtManagerUI":
			a = new SprtManagerUIAction();
			break;
			
		case "sprtBfManagerUI":
			a = new SprtBfManagerUIAction();
			break;
			
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
//		case "setSprtInfo": 
//			a = new SetSprtInfoAction();
//			break;
			

		default:
			a = new MainUIAction(); 
			break;
		}
		return a;
	}
}
  
