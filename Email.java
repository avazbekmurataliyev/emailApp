package emailapp;
 	import java.util.*;
 	import java.io.*;
public class Email {
	public Scanner in = new Scanner(System.in);
	private String firstName ;
	private String lastName ;
	private String dept ;
	private String email ;
	private String password ;
	private int mailCapacity = 500 ;
	private String alterEmail;
	
	public Email(String firstName , String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName ;
		this.dept = this.setDept();
		this.password = this.generatePass(8);
		this.email = this.generateEmail();
		System.out.println(this.firstName + " "+ this.lastName);
	}
	
	private String generateEmail() {
		return this.firstName.toLowerCase()+this.lastName.toLowerCase()+"@"+this.dept.toLowerCase()+"compny.com";
	}
	private String setDept() {
		System.out.println(" Department codes \n 1 : for Sale \n 2 : for Development \n 3 : for Accounting");
	boolean flag = false;
		do {
			System.out.println("Enter department code ");
			int choice = in.nextInt();
			switch(choice) {
			case 1: return "Sales";
			case 2: return "Development";
			case 3: return "Accounting";
			default : System.out.println("Invalid choice code  enter it again");
			}
		}
		while(!flag);
			return null;
	}
	
	
	private String generatePass(int length) {
		
		String pass="" ;
		String upperLitters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerLitters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String characters = "!@#$%*?";
		String allChars = upperLitters + lowerLitters + numbers +characters;
		Random ran = new Random();
		for(int i = 0; i < length; i++) {
			pass += allChars.charAt(ran.nextInt(allChars.length()));
		}
		
		return pass ;
	}
	
	public void setPassword() {
		boolean flag = false ;
		do {
			System.out.println(" Do you want to change your password ? Y/N");
			char choice = in.next().charAt(0);
			if(choice =='Y' || choice == 'y') {
				System.out.println("Enter current password ");
				String temp = in.next();
				if(temp.equals(this.password)) {
					System.out.println("Enter new password");
					this.password = in.next();
				System.out.println("Password change succes");
				}
				else {
					System.out.println("Invalid password ");
					
				}
				
			}
			else if(choice =='N' || choice == 'n') {
				flag = true ;
				System.out.println("Password changed option cancelled");
			}
			else 
				System.out.println("Please enter valid choice");
		}
		while(!flag);
		
	}
	
	public void setMailCap() {
		System.out.println("Current capacity "+this.mailCapacity + "mb");
	
	System.out.println("Enter new mailbox capacity : ");
	this.mailCapacity  = in.nextInt();
	System.out.println("Mailbox capacity is succesfully changed ");
	}
	public void alternateEmail() {
		System.out.println("Enter new alternate mail : ");
		this.alterEmail = in.next();
		System.out.println("Alternate email is set");
	}
	
	public void getInfo() {
		
		System.out.println("New : "+this.firstName + " " + this.lastName);
		System.out.println("Department : " +this.dept);
		System.out.println("Email : " + this.email);
		System.out.println("Password : " +this.password);
		System.out.println("Mailbox capacity " + this.mailCapacity + "mb");
		System.out.println("Alternate mail "+ this.alterEmail);
		
	}
	public String toString() {
		return "First Name"+this.firstName +
				" \n "+"Last Name" + this.lastName+
				"\n"+ "Department : " +this.dept
				+ "\n Email : " + this.email+"\n"
				+ " Password : " +this.password+"\n"
				+ "	Mailbox capacity " + this.mailCapacity + "mb"+"\n"
				+ "	Alternate mail "+ this.alterEmail;
	}
	
	
	public void saveFile() {
		
		try {
			File file = new File("D:"+File.pathSeparator+this.firstName+".txt");
			file.createNewFile();
			FileWriter fwrite = new FileWriter(file);
			fwrite.write("First Name : "+this.firstName);
			fwrite.append("\n  # Last name : "+this.lastName);
			fwrite.append("\n # Email : "+this.email);
			fwrite.append("\n #  password : "+this.password);
			fwrite.append("\n  # Capacity : "+this.mailCapacity);
			fwrite.append("\n # Alternate mail : "+this.alterEmail);
			fwrite.close();
			System.out.println(" Data saved ");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void readFile() {
		try {
			File file = new File("D:"+File.pathSeparator+this.firstName+".txt");
			if(file.canRead()) {
				FileReader fread = new FileReader(file);
				int index ;
				while((index = fread.read())!= -1) {
					if(index == (int)'#')
						System.out.println();
					System.out.print((char)index);
				}
				fread.close();
				
			}
			}
		
	catch(Exception e) {
		System.out.println("Read file error"+e);
	}
	}
	
	
}
