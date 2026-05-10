package project.com; // Package name must be the same in all files

import java.util.ArrayList; // For dynamic list storage
import java.io.*;           // For File writing and reading
import java.util.Scanner;    // For scanning file content

public class RepairManager {
    // Stores all gadget objects in memory during runtime
    private ArrayList<Gadget> gadgetList = new ArrayList<Gadget>();
    private String fileName = "repairs.txt"; // The file used as a database

    // Method to add a gadget to our list
    public void addGadget(Gadget g) {
        gadgetList.add(g);
    }

    // Displays all repairs currently in the system
    public void showAll() {
        if (gadgetList.size() == 0) System.out.println("No records found.");
        for (int i = 0; i < gadgetList.size(); i++) {
            gadgetList.get(i).displayDetails();
        }
    }

    // Search logic: Checks if a customer exists by comparing Name and Password
    public void customerLogin(String name, String pass) {
        boolean found = false;
        for (int i = 0; i < gadgetList.size(); i++) {
            Gadget g = gadgetList.get(i);
            // .equalsIgnoreCase ignores capital/lowercase differences
            if (g.getCustomerName().equalsIgnoreCase(name) && g.getPassword().equals(pass)) {
                g.displayDetails();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Error: Name or Password incorrect.");
    }

    // Saves the ArrayList content into "repairs.txt" in CSV format
    public void saveToDisk() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < gadgetList.size(); i++) {
                Gadget g = gadgetList.get(i);
                writer.println(g.getTicketId() + "," + g.getDeviceName() + "," + g.getCustomerName() + "," + g.getPassword() + "," + g.getProblem() + "," + g.getRepairStatus() + "," + g.getEstimatedCost() + "," + g.getEstimatedTime());
            }
            writer.close(); // Finalize and save file
        } catch (Exception e) { System.out.println("Save error occurred."); }
    }

    // Reads "repairs.txt" and creates Gadget objects to fill the ArrayList
    public void loadFromDisk() {
        try {
            File f = new File(fileName);
            if (f.exists()) {
                Scanner reader = new Scanner(f);
                while (reader.hasNextLine()) {
                    String[] d = reader.nextLine().split(","); // Split text by commas
                    gadgetList.add(new Gadget(d[0], d[1], d[2], d[3], d[4], d[5], Double.parseDouble(d[6]), d[7]));
                }
                reader.close();
            }
        } catch (Exception e) { System.out.println("Load error occurred."); }
    }
}