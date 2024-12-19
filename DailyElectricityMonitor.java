/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testing;

import java.util.Scanner;

public class DailyElectricityMonitor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElectricityMonitor monitor = new ElectricityMonitor(0.15, 10); // $0.15 per kWh and max 10 appliances

        while (true) {
            System.out.println("\n--- Electricity Monitor Menu ---");
            System.out.println("1. Add Appliance");
            System.out.println("2. Remove Appliance");
            System.out.println("3. Update Usage Hours");
            System.out.println("4. View All Appliances");
            System.out.println("5. Calculate Total Consumption and Cost");
            System.out.println("6. Find Most Power-Consuming Appliance");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add appliance
                    System.out.print("Enter appliance name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter power rating (kW): ");
                    double powerRating = scanner.nextDouble();
                    System.out.print("Enter hours used per day: ");
                    double hoursUsed = scanner.nextDouble();
                    monitor.addAppliance(new Appliance(name, powerRating, hoursUsed));
                    System.out.println("Appliance added successfully!");
                    break;

                case 2:
                    // Remove appliance
                    System.out.print("Enter appliance name to remove: ");
                    String removeName = scanner.nextLine();
                    if (monitor.removeAppliance(removeName)) {
                        System.out.println("Appliance removed successfully!");
                    } else {
                        System.out.println("Appliance not found.");
                    }
                    break;

                case 3:
                    // Update usage hours
                    System.out.print("Enter appliance name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new usage hours per day: ");
                    double newHours = scanner.nextDouble();
                    if (monitor.updateHoursUsed(updateName, newHours)) {
                        System.out.println("Usage hours updated!");
                    } else {
                        System.out.println("Appliance not found.");
                    }
                    break;

                case 4:
                    // Display appliances
                    monitor.displayAppliances();
                    break;

                case 5:
                    // Calculate total consumption and cost
                    double totalConsumption = monitor.calculateTotalConsumption();
                    double totalCost = monitor.calculateTotalCost();
                    System.out.printf("Total Daily Consumption: %.2f kWh\n", totalConsumption);
                    System.out.printf("Total Daily Cost: $%.2f\n", totalCost);
                    break;

                case 6:
                    // Find most power-consuming appliance
                    Appliance mostConsuming = monitor.getMostConsumingAppliance();
                    if (mostConsuming != null) {
                        System.out.printf("Most Power-Consuming Appliance: %s (%.2f kWh)\n",
                                mostConsuming.getName(), mostConsuming.calculateDailyConsumption());
                    } else {
                        System.out.println("No appliances added yet!");
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


