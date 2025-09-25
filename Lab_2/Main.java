// file Main.java
package Lab_2;

public class Main {
    public static void main(String[] args) {

        ElectricStove obj = new ElectricStove("Bosch");

        ElectricStove stove = new ElectricStove("Samsung Chef", "Induction", 3.5, 4, 
                "Samsung", 92.5, true, "Black");

        stove.calculateEnergyConsumption(5); // розрахунок енергоспоживання за 5 годин
        stove.showAllAttributes();

        obj.showAllAttributes();

        stove.comparePower(obj);
    }
}
