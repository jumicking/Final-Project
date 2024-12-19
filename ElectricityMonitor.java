/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

/**
 *
 * @author Abram
 */
class ElectricityMonitor {
    private Appliance[] appliances;
    private int applianceCount;
    private double costPerKWh;

    // Constructor
    public ElectricityMonitor(double costPerKWh, int maxAppliances) {
        this.costPerKWh = costPerKWh;
        this.appliances = new Appliance[maxAppliances];
        this.applianceCount = 0;
    }

    // Add appliance
    public void addAppliance(Appliance appliance) {
        if (applianceCount < appliances.length) {
            appliances[applianceCount++] = appliance;
        } else {
            System.out.println("Max appliance limit reached. Cannot add more.");
        }
    }

    // Update usage hours
    public boolean updateHoursUsed(String name, double hours) {
        for (int i = 0; i < applianceCount; i++) {
            if (appliances[i].getName().equalsIgnoreCase(name)) {
                appliances[i].setHoursUsed(hours);
                return true;
            }
        }
        return false;
    }

    // Remove appliance by name
    public boolean removeAppliance(String name) {
        for (int i = 0; i < applianceCount; i++) {
            if (appliances[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < applianceCount - 1; j++) {
                    appliances[j] = appliances[j + 1];
                }
                appliances[--applianceCount] = null;
                return true;
            }
        }
        return false;
    }

    // Calculate total daily consumption
    public double calculateTotalConsumption() {
        double total = 0;
        for (int i = 0; i < applianceCount; i++) {
            total += appliances[i].calculateDailyConsumption();
        }
        return total;
    }

    // Calculate total cost
    public double calculateTotalCost() {
        return calculateTotalConsumption() * costPerKWh;
    }

    // Display all appliances
    public void displayAppliances() {
        if (applianceCount == 0) {
            System.out.println("No appliances added yet!");
            return;
        }
        System.out.println("\nAppliances List:");
        for (int i = 0; i < applianceCount; i++) {
            System.out.println(appliances[i]);
        }
    }

    // Find the most power-consuming appliance
    public Appliance getMostConsumingAppliance() {
        Appliance mostConsuming = null;
        double maxConsumption = 0;
        for (int i = 0; i < applianceCount; i++) {
            double consumption = appliances[i].calculateDailyConsumption();
            if (consumption > maxConsumption) {
                maxConsumption = consumption;
                mostConsuming = appliances[i];
            }
        }
        return mostConsuming;
    }
}


