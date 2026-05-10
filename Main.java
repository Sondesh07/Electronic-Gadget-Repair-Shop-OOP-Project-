package project.com; // Package name remains consistent

import java.util.Scanner; //used scanner for user input

public class Main {
    public static void main(String[] args) {
        RepairManager rm = new RepairManager(); // Create the object for logic engine
        rm.loadFromDisk();                      // Load data from file at startup
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- GADGET SHOP LOGIN ---");
            System.out.println("1. Admin Portal ");
            System.out.println("2. Customer Portal");
            System.out.println("3. Exit System");
            System.out.print("Choose: ");
            int portal = input.nextInt();
            input.nextLine(); // Clear the input buffer

            if (portal == 1) { // OWNER LOGIN SECTION
                System.out.print("Enter Owner Name: "); String oName = input.nextLine();
                System.out.print("Enter Password: "); String oPass = input.nextLine();

                // Authentication for Bishal
                if (oName.equalsIgnoreCase("admin") && oPass.equals("admin123")) {
                    ownerMenu(rm, input);
                } else {
                    System.out.println("Access Denied: Wrong Credentials.");
                }
            }
            else if (portal == 2) { // CUSTOMER LOGIN SECTION
                System.out.print("Enter Your Name: "); String name = input.nextLine();
                System.out.print("Enter Your Password: "); String pass = input.nextLine();
                rm.customerLogin(name, pass); // Automatic detail retrieval
            }
            else if (portal == 3) { // EXIT AND SAVE
                rm.saveToDisk();
                System.out.println("All data saved. Thank you!");
                break;
            }
        }
    }

    // Secondary menu for Admin to perform management tasks
    public static void ownerMenu(RepairManager rm, Scanner input) {
        int choice = 0;
        while (choice != 3) { //exits as soon as 3 is pressed
            System.out.println("\n--- OWNER MANAGEMENT PANEL ---");
            System.out.println("1. Register New Repair");
            System.out.println("2. View All Customer Records");
            System.out.println("3. Logout");
            System.out.print("Action: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) { // Create a new data entry
                System.out.print("Ticket ID: "); String id = input.nextLine();
                System.out.print("Device: "); String dev = input.nextLine();
                System.out.print("Customer Name: "); String name = input.nextLine();
                System.out.print("Set Password: "); String pass = input.nextLine();
                System.out.print("What is the Problem: "); String prob = input.nextLine();
                System.out.print("Estimated Time: "); String time = input.nextLine();
                System.out.print("Cost: "); double cost = input.nextDouble();

                // Construct object and add it to the manager
                rm.addGadget(new Gadget(id, dev, name, pass, prob, "IN-PROGRESS", cost, time));
                System.out.println("Ticket Registered Successfully.");
            }
            else if (choice == 2) { // Display all data entries
                rm.showAll();
            }
        }
    }
}