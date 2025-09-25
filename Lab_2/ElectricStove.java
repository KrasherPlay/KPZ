// file ElectricStove.java
package Lab_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElectricStove {
    private String name;
    private String type;
    private double power;       // потужність (кВт)
    private int burners;        // кількість конфорок
    private String manufacturer;
    private double efficiency;  // ККД (%)
    private boolean hasOven;
    private String color;
    private double energyConsumed; // розрахунок енергії

    // Конструктор без параметрів
    public ElectricStove() {
        this.name = "Custom Stove";
        this.type = "unknown";
        this.power = 0.0;
        this.burners = 0;
        this.manufacturer = "unknown";
        this.efficiency = 0.0;
        this.hasOven = false;
        this.color = "unknown";
        this.energyConsumed = 0.0;
    }

    // Конструктор з усіма параметрами
    public ElectricStove(String name, String type, double power, int burners, String manufacturer,
                         double efficiency, boolean hasOven, String color) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.burners = burners;
        this.manufacturer = manufacturer;
        this.efficiency = efficiency;
        this.hasOven = hasOven;
        this.color = color;
        this.energyConsumed = 0.0;
    }

    // Конструктор з одним параметром
    public ElectricStove(String name) {
        this.name = name;
        this.type = "unknown";
        this.power = 0.0;
        this.burners = 0;
        this.manufacturer = "unknown";
        this.efficiency = 0.0;
        this.hasOven = false;
        this.color = "unknown";
        this.energyConsumed = 0.0;
    }

    // Логування дій
    private void logAction(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Lab_2/activity.log", true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            writer.println(dtf.format(now) + " - " + message);
        } catch (IOException e) {
            System.err.println("Logs written attempt error: " + e.getMessage());
        }
    }

    // Показати всі атрибути
    public void showAllAttributes() {
        logAction("Method showAllAttributes() called for: " + name);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Power (kW): " + power);
        System.out.println("Burners: " + burners);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Efficiency (%): " + efficiency);
        System.out.println("Has oven: " + hasOven);
        System.out.println("Color: " + color);
        System.out.println("Energy Consumed (kWh): " + energyConsumed);
        System.out.println("\n");
    }

    // Розрахунок енергоспоживання
    public void calculateEnergyConsumption(double hours) {
        logAction("Method calculateEnergyConsumption() called for: " + name);
        this.energyConsumed = this.power * hours * (this.efficiency / 100);
    }

    // Порівняння потужності
    public void comparePower(ElectricStove other) {
        logAction("comparePower(ElectricStove other) called");
        if (this.power > other.power) {
            System.out.println(this.name + " has higher power than " + other.name);
        } else if (this.power < other.power) {
            System.out.println(this.name + " has lower power than " + other.name);
        } else {
            System.out.println(this.name + " has equal power to " + other.name);
        }
    }

    // Очистити лог-файл
    public void clearLogFile() {
        try {
            FileWriter writer = new FileWriter("Lab_2/activity.log", false);
            writer.close();
            System.out.println("Log file 'activity.log' has been cleared.");
        } catch (IOException e) {
            System.err.println("Logs cleaning error: " + e.getMessage());
        }
    }
}
