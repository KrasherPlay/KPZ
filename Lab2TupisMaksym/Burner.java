package Lab2TupisMaksym;

/**
 * Клас, що описує конфорку плитки.
 */
public class Burner {
    private final double diameter; // в сантиметрах
    private boolean isHot;

    public Burner(double diameter) {
        this.diameter = diameter;
        this.isHot = false;
    }

    public void heatUp() {
        this.isHot = true;
    }

    public void coolDown() {
        this.isHot = false;
    }

    @Override
    public String toString() {
        return "Конфорка (діаметр: " + diameter + " см, гаряча: " + isHot + ")";
    }
}