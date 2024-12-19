/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

/**
 *
 * @author Abram
 */
class Appliance {
    private String name;
    private double powerRating; // Power in kW
    private double hoursUsed; // Hours used per day

    // Constructor
    public Appliance(String name, double powerRating, double hoursUsed) {
        this.name = name;
        this.powerRating = powerRating;
        this.hoursUsed = hoursUsed;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public double getPowerRating() {
        return powerRating;
    }

    public double getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(double hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    // Calculate daily energy consumption (kWh)
    public double calculateDailyConsumption() {
        return powerRating * hoursUsed;
    }

    // String representation of appliance
   
    public String toString() {
        return String.format("%s (Power: %.2f kW, Hours: %.2f, Daily Consumption: %.2f kWh)",
                name, powerRating, hoursUsed, calculateDailyConsumption());
    }
}


