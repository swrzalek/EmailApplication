package emailapp;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String CompanyName = "iwanttoworkforyou.com";


    //Constructor to recive the first name and last name
    public Email(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        //Call a method asking for the department = return the department
        this.department = setDepartment();

        //Call a method that return random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        //Combine all to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + CompanyName;
    }

    //Ask for department
    private String setDepartment(){
        System.out.print("New worker " + firstName + ". Department Codes:\n1 for Sale\n2 for Development\n3 for Accounting\n0 for none\n ENTER DEPARTMENT CODE: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice ==1 ) {return "sales";}
        else if (depChoice ==2 ) {return "dev"; }
        else if (depChoice == 3) {return "acct";}
        else {return "";}

    }
//Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);

        }
        return new String(password);

    }
//Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;

    }
//Set the alternate email
    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }
//Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() {return alternateEmail; }
    public String getPassword() {return password;}

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY:" + mailboxCapacity + "mb";
    }
}