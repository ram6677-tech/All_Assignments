import java.util.*; 
class Contact { 
private String name; 
private String phone; 
private String email; 
public Contact(String name, String phone, String email) { 
this.name = name; 
this.phone = phone; 
this.email = email; 
} 
    public String getName() { return name; } 
    public String getPhone() { return phone; } 
    public String getEmail() { return email; } 
 
    public void setName(String name) { this.name = name; } 
    public void setEmail(String email) { this.email = email; } 
 
    @Override 
    public String toString() { 
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email; 
    } 
} 
 
public class ContactManagementSystem { 
 
    private static ArrayList<Contact> contactList = new ArrayList<>(); 
    private static HashMap<String, Contact> contactMap = new HashMap<>(); 
    private static Scanner sc = new Scanner(System.in); 

    private static void addContact() { 
        try { 
            System.out.print("Enter name: "); 
            String name = sc.nextLine(); 
 
            System.out.print("Enter phone: "); 
            String phone = sc.nextLine(); 
 
            if (contactMap.containsKey(phone)) { 
                throw new IllegalArgumentException("Duplicate phone number!"); 
            } 
 
            System.out.print("Enter email: "); 
            String email = sc.nextLine(); 
 
            Contact c = new Contact(name, phone, email); 
            contactList.add(c); 
            contactMap.put(phone, c); 
 
            System.out.println("Contact added successfully."); 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
        } 
    } 
 
    private static void searchContact() { 
        System.out.print("Enter phone number to search: "); 
        String phone = sc.nextLine(); 
 
        Contact c = contactMap.get(phone); 
        if (c != null) { 
            System.out.println(c); 
        } else { 
            System.out.println("Contact not found."); 
        } 
    } 
 
    private static void updateContact() { 
        System.out.print("Enter phone number to update: "); 
        String phone = sc.nextLine(); 
 
        Contact c = contactMap.get(phone); 
        if (c == null) { 
            System.out.println("Contact not found."); 
            return; 
        } 
 
        System.out.print("Enter new name: "); 
        c.setName(sc.nextLine()); 
 
        System.out.print("Enter new email: "); 
        c.setEmail(sc.nextLine()); 
 
        System.out.println("Contact updated successfully."); 
    } 
 
    private static void deleteContact() { 
        System.out.print("Enter phone number to delete: "); 
        String phone = sc.nextLine(); 
 
        Contact c = contactMap.remove(phone); 
        if (c != null) { 
            contactList.remove(c); 
            System.out.println("Contact deleted successfully."); 
        } else { 
            System.out.println("Contact not found."); 
        } 
    } 
 
    private static void displayContacts() { 
        if (contactList.isEmpty()) { 
            System.out.println("No contacts available."); 
            return; 
        } 
        for (Contact c : contactList) { 
            System.out.println(c); 
        } 
    } 
 
    public static void main(String[] args) { 
 
        while (true) { 
            System.out.println("\n--- Contact Management System ---"); 
            System.out.println("1. Add Contact"); 
            System.out.println("2. Search Contact"); 
            System.out.println("3. Update Contact"); 
            System.out.println("4. Delete Contact"); 
            System.out.println("5. Display All Contacts"); 
            System.out.println("6. Exit"); 
            System.out.print("Choose option: "); 
 
            try { 
                int choice = Integer.parseInt(sc.nextLine()); 
 
                switch (choice) { 
                    case 1 -> addContact(); 
                    case 2 -> searchContact(); 
                    case 3 -> updateContact(); 
                    case 4 -> deleteContact(); 
                    case 5 -> displayContacts(); 
                    case 6 -> { 
                        System.out.println("Exiting..."); 
                        return; 
                    } 
                    default -> System.out.println("Invalid choice."); 
                } 
            } catch (NumberFormatException e) { 
                System.out.println("Please enter a valid number."); 
            } 
} 
} 
}