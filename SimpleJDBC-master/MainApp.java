import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        ContactDAO dao = new ContactDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Add Contact");
            System.out.println("2 View Contacts");
            System.out.println("3 Search Contact");
            System.out.println("4 Update Contact");
            System.out.println("5 Delete Contact");
            System.out.println("6 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    dao.addContact(name, email, phone);
                    break;

                case 2:
                    dao.viewContacts();
                    break;

                case 3:
                    System.out.print("Search name: ");
                    dao.searchByName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New phone: ");
                    dao.updateContact(id, sc.nextLine());
                    break;

                case 5:
                    System.out.print("ID: ");
                    dao.deleteContact(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}

