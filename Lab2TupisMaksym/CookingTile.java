package Lab2TupisMaksym;

/**
 * Клас, що реалізує предметну область "Плитка для приготування їжі".
 */
public class CookingTile {
    // --- Поля класу ---
    private final String modelName;
    private boolean isOn;
    private final Logger logger;

    // --- Об'єкти класів, що описують складові частини ---
    private final Burner burner;
    private final HeatingElement heatingElement;
    private final ControlKnob controlKnob;

    // --- Конструктори ---

    /**
     * Конструктор за замовчуванням.
     */
    public CookingTile() {
        this.modelName = "Default Model";
        this.burner = new Burner(18.0);
        this.heatingElement = new HeatingElement("Керамічний", 700);
        this.controlKnob = new ControlKnob(9);
        this.isOn = false;
        this.logger = Logger.getInstance();
        logger.log("Створено об'єкт CookingTile (конструктор за замовчуванням): " + modelName);
    }

    /**
     * Параметризований конструктор.
     */
    public CookingTile(String modelName, Burner burner, HeatingElement element, ControlKnob knob) {
        this.modelName = modelName;
        this.burner = burner;
        this.heatingElement = element;
        this.controlKnob = knob;
        this.isOn = false;
        this.logger = Logger.getInstance();
        logger.log("Створено об'єкт CookingTile (параметризований конструктор): " + modelName);
    }

    /**
     * Конструктор копіювання.
     */
    public CookingTile(CookingTile other) {
        this.modelName = other.modelName + "_copy";
        this.burner = new Burner(other.burner.toString().contains("18.0") ? 18.0 : 22.0); // Проста логіка для копіювання
        this.heatingElement = new HeatingElement(other.heatingElement.toString().contains("Індукційний") ? "Індукційний" : "Керамічний", 750);
        this.controlKnob = new ControlKnob(other.controlKnob.toString().contains("9") ? 9 : 12);
        this.isOn = other.isOn;
        this.logger = Logger.getInstance();
        logger.log("Створено копію об'єкта CookingTile: " + this.modelName);
    }

    // --- Методи класу ---

    public void turnOn() {
        logger.log("Спроба увімкнути плитку " + modelName);
        if (!isOn) {
            this.isOn = true;
            logger.log("Плитку " + modelName + " увімкнено.");
        } else {
            logger.log("Плитка " + modelName + " вже увімкнена.");
        }
    }

    public void turnOff() {
        logger.log("Спроба вимкнути плитку " + modelName);
        if (isOn) {
            this.isOn = false;
            this.setPowerLevel(0); // Скидаємо потужність при вимкненні
            this.burner.coolDown();
            logger.log("Плитку " + modelName + " вимкнено. Конфорка охолоджується.");
        } else {
            logger.log("Плитка " + modelName + " вже вимкнена.");
        }
    }

    public void setPowerLevel(int level) {
        logger.log("Встановлення рівня потужності " + level + " для плитки " + modelName);
        if (isOn) {
            controlKnob.setLevel(level);
            if (level > 0) {
                burner.heatUp();
                logger.log("Рівень потужності встановлено на " + level + ". Конфорка нагрівається.");
            } else {
                burner.coolDown();
                logger.log("Рівень потужності встановлено на 0. Конфорка охолоджується.");
            }
        } else {
            logger.log("Неможливо встановити потужність. Плитка " + modelName + " вимкнена.");
        }
    }

    public void increasePower() {
        logger.log("Збільшення потужності для плитки " + modelName);
        int currentLevel = controlKnob.getCurrentLevel();
        setPowerLevel(currentLevel + 1);
    }

    public void decreasePower() {
        logger.log("Зменшення потужності для плитки " + modelName);
        int currentLevel = controlKnob.getCurrentLevel();
        setPowerLevel(currentLevel - 1);
    }

    public String getStatus() {
        String status = "Статус плитки '" + modelName + "': " + (isOn ? "Увімкнена" : "Вимкнена") +
                        ". Рівень потужності: " + controlKnob.getCurrentLevel();
        logger.log("Запит статусу для " + modelName + ". Поточний статус: " + status);
        return status;
    }
    
    public String getModelName() {
        logger.log("Запит назви моделі: " + this.modelName);
        return this.modelName;
    }

    public String getBurnerInfo() {
        String info = this.burner.toString();
        logger.log("Запит інформації про конфорку для " + modelName + ": " + info);
        return info;
    }

    public String getHeatingElementInfo() {
        String info = this.heatingElement.toString();
        logger.log("Запит інформації про нагрівальний елемент для " + modelName + ": " + info);
        return info;
    }
    
    public String getControlKnobInfo() {
        String info = this.controlKnob.toString();
        logger.log("Запит інформації про ручку керування для " + modelName + ": " + info);
        return info;
    }
}