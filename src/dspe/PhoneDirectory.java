package dspe;

import java.util.Scanner;

public class PhoneDirectory implements LookContact {

    private SinglyLinkedList<Contact> contactList;//sorted    
    private LLstack<Contact> searchHistory;

    public PhoneDirectory() {
        contactList = new SinglyLinkedList<>();
        searchHistory = new LLstack<>();
        fillcontacts();
    }

    public void addNewContact() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String number = input.nextLine();
        System.out.print("Enter the Firstname: ");
        String Firstname = input.nextLine();
        System.out.print("Enter the Lastname: ");
        String Lastname = input.nextLine();
        System.out.print("Enter the gender: ");
        char gender = input.next().charAt(0);

        Contact contact = new Contact(number, new Name(Firstname, Lastname), gender);

        contactList.sortedInsert(contact);
        System.out.println("Contact has been added successfully!");
    }

    public void deleteContact() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contact number: ");
        String number = input.next();

        Contact contact = contactList.searchContactNumber(number);
        if (contact == null) {
            System.out.println("Contact with this number is not in the directory.");
        } else {
            contactList.remove(contact);
            System.out.println("Contact has been removed succssfully!");
        }
    }

    public void displayAll() {
        if (contactList.isEmpty()) {
            System.out.println("Directory is empty!");
        } else {
            contactList.display();
        }
    }

    @Override
    public void contactsByGender() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the gender: ");
        char gender = input.next().charAt(0);
        SinglyLinkedList<Contact> cList = contactList.contactsByGender(gender);

        if (cList.isEmpty()) {
            System.out.println("No contacts found of this gender");
        } else {
            System.out.println("Contacts by gender " + gender + " are: ");
            cList.display();
        }
    }
    

    @Override
    public void searchContactNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contact number: ");
        String number = input.next();

        Contact contact = contactList.searchContactNumber(number);
        if (contact == null) {
            System.out.println("Contact with this number is not found in the directory.");
        } else {
            System.out.println("Contact Info: ");
            System.out.println(contact);
            searchHistory.push(contact);
        }
    }

    //stack
    public void didSearch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String number = input.next();
        boolean result = searchHistory.didSearch(number);
        if (result == true) {
            System.out.println("You searched for this number before");
        } else {
            System.out.println("You did not search for this number");
        }
    }

    public void countSearch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String number = input.next();
        int count = searchHistory.countSearch(number);
        System.out.println("You searched for this number " + count + " times.");
    }

    public void displaySearchHistory() {
        if (searchHistory.isEmpty()) {
            System.out.println("Search history is empty.");
        } else {
            System.out.println("Search History: ");
            searchHistory.display();
        }
    }

    public void mostRecentSearch() {
        searchHistory.mostRecentSearch();
    }

    public void deleteAllSearchHistory() {
        searchHistory.deleteAllSearchHistory();
    }

     
    public void fillcontacts() {
        Contact c1 = new Contact("966252536", new Name("Saja", "Aljamal"), 'F');
        Contact c2 = new Contact("966343426", new Name("Fajer", "Aleid"), 'F');
        Contact c3 = new Contact("966243478", new Name("Rama", "Radi"), 'F');
        Contact c4 = new Contact("966253536", new Name("Latifah", "Alyahya"), 'F');
        Contact c5 = new Contact("966535463", new Name("Gharam", "Alqrni"), 'F');

        contactList.sortedInsert(c1);
        contactList.sortedInsert(c2);
        contactList.sortedInsert(c3);
        contactList.sortedInsert(c4);
        contactList.sortedInsert(c5);
    }

}
