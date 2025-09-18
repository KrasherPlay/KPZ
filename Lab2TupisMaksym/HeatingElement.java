package Lab2TupisMaksym;

/**
 * Клас, що описує нагрівальний елемент.
 */
public class HeatingElement {
    private final String type; // напр. "Індукційний", "Керамічний"
    private final int maxTemperature; // в градусах Цельсія

    public HeatingElement(String type, int maxTemperature) {
        this.type = type;
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Нагрівальний елемент (тип: " + type + ", макс. t°: " + maxTemperature + "°C)";
    }
}