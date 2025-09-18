package Lab2TupisMaksym;

/**
 * Клас, що описує ручку керування потужністю.
 */
public class ControlKnob {
    private final int maxLevel;
    private int currentLevel;

    public ControlKnob(int maxLevel) {
        this.maxLevel = maxLevel;
        this.currentLevel = 0; // Початковий рівень - 0
    }

    public void setLevel(int level) {
        if (level >= 0 && level <= maxLevel) {
            this.currentLevel = level;
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public String toString() {
        return "Ручка керування (поточний рівень: " + currentLevel + "/" + maxLevel + ")";
    }
}