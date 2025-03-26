import java.io.*;
import java.util.Scanner;

//Module 1 Getting Username and password
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();
        Loggin l = new Loggin();
        int x = 1;
        String newUsername ;
        char[] password ;
        while(x!=0){
            System.out.println("1->Login\n2->Add User\n3->Exit\n");
            x=sc.nextInt();
            switch (x) {
                //login
                case 1:
                    sc.next();
                    newUsername = sc.nextLine();
                    password = console.readPassword("Enter Password");
                    if(l.login(newUsername,password)){
                        System.out.println("Successfully login");
                    }
                    else{
                        System.out.println("Username or Password is wrong");
                    }

                    break;
                //new user
                case 2:
                    sc.next();
                    newUsername = sc.nextLine();
                    password = console.readPassword("Enter Password");
                    while(l.checkUsername(newUsername)){
                        System.out.println("Enter new Username Already Exists");
                        newUsername = sc.nextLine();
                    }
                    System.out.println(l.addUser(newUsername,password));
                    break;

                case 3:
                    x = 0;
                    System.out.println("Thank You");
                    break;
            }
        }
    }
}