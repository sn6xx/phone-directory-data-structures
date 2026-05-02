package dspe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PhoneDirectory directory = new PhoneDirectory();
        System.out.println("*** Welcome To Phone Directory ***");
        int option = 0;
        do {
            try {
                System.out.print("\n1. New Contact\n"
                        + "2. Delete Contact\n"
                        + "3. Display All\n"
                        + "4. Search By Number\n"
                        + "5. Search By Gender\n"
                        + "6. Display Search\n"
                        + "7. Most Recent Search\n"
                        + "8. Count Search \n"
                        + "9. Delete All Search\n"
                        + "10. Exit\n"
                        + ">> ");
                option = input.nextInt();
                switch (option) {

                    case 1:
                        directory.addNewContact();
                        break;

                    case 2:
                        directory.deleteContact();
                        break;

                    case 3:
                        directory.displayAll();
                        break;
                    case 4:
                        directory.searchContactNumber();
                        break;

                    case 5:
                        directory.contactsByGender();
                        break;

                    case 6:
                        directory.displaySearchHistory();
                        break;

                    case 7:
                        directory.mostRecentSearch();
                        break;

                    case 8:
                       directory.countSearch(); 
                        break;

                    case 9:
                       directory.deleteAllSearchHistory();
                        break;
                     
                    case 10:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
                input.next();
            }
        } while (option != 10);

    }
}
