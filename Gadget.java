package project.com; // Package declaration for organization

public class Gadget {
    // Private variables (Encapsulation: data is hidden from outside)
    private String ticketId;
    private String deviceName;
    private String customerName;
    private String password;
    private String problem;
    private String repairStatus;
    private double estimatedCost;
    private String estimatedTime;

    // Constructor: Assigns values to a new Gadget object when it's created
    public Gadget(String ticketId, String deviceName, String customerName, String password, String problem, String repairStatus, double estimatedCost, String estimatedTime) {
        this.ticketId = ticketId;
        this.deviceName = deviceName;
        this.customerName = customerName;
        this.password = password;
        this.problem = problem;
        this.repairStatus = repairStatus;
        this.estimatedCost = estimatedCost;
        this.estimatedTime = estimatedTime;
    }

    // Public Getters: These allow other classes to safely "read" the private data
    public String getTicketId() { return ticketId; }
    public String getDeviceName() { return deviceName; }
    public String getCustomerName() { return customerName; }
    public String getPassword() { return password; }
    public String getProblem() { return problem; }
    public String getRepairStatus() { return repairStatus; }
    public double getEstimatedCost() { return estimatedCost; }
    public String getEstimatedTime() { return estimatedTime; }

    // Method to display a formatted receipt/ticket of the device
    public void displayDetails() {
        System.out.println("\n--- REPAIR TICKET ---");
        System.out.println("Customer: " + customerName + " | ID: " + ticketId);
        System.out.println("Device:   " + deviceName);
        System.out.println("Problem:  " + problem);
        System.out.println("Status:   " + repairStatus);
        System.out.println("Est. Time:" + estimatedTime + " | Cost: $" + estimatedCost);
        System.out.println("---------------------");
    }
}