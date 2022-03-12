package emailapp;

import java.util.*;
public class EmailApp {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter your firs Name ");
		String firstName = in.next();
		System.out.println("Enter your last Name ");
		String lastName = in.next();
		
		Email email = new Email(firstName, lastName);
		boolean finish = false;
		int choice = -1;
		do {
			System.out.println("\n ------------ \n Enter your choice \n 1 : Show info"
					+ "\n 2 : Change password  \n 3 : change mailbox capacity \n 4 : Alternate mail"
					+ "\n 5 File save \n 6 File read \n 7 EXIT ");
			choice = in.nextInt();
			switch(choice) {
			case 1: email.getInfo();break;
			case 2: email.setPassword();break;
			case 3: email.setMailCap();break;
			case 4: email.alternateEmail();break;
			case 5: email.saveFile();break;
			case 6: email.readFile();break;
			case 7: finish = true ; break;
			default: System.out.println("Please valid code input");
			}
		}
		while(!finish);
	}

}
