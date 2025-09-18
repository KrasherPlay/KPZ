package Lab2TupisMaksym;

/**
 * Клас-драйвер для тестування та демонстрації роботи класу CookingTile.
 */
public class CookingTileDriver {
    public static void main(String[] args) {
        // Використання try-with-resources для гарантованого закриття логера
        try (Logger logger = Logger.getInstance()) {
            logger.log("--- Початок демонстрації роботи програми ---");

            // 1. Створення об'єкта за допомогою конструктора за замовчуванням
            System.out.println("1. Створення плитки за замовчуванням:");
            CookingTile defaultTile = new CookingTile();
            System.out.println(defaultTile.getStatus());
            System.out.println("------------------------------------------");

            // 2. Демонстрація роботи методів
            System.out.println("2. Демонстрація роботи з плиткою '" + defaultTile.getModelName() + "':");
            defaultTile.turnOn();
            defaultTile.setPowerLevel(5);
            System.out.println(defaultTile.getStatus());
            System.out.println(defaultTile.getBurnerInfo());
            defaultTile.increasePower();
            System.out.println(defaultTile.getStatus());
            defaultTile.turnOff();
            System.out.println(defaultTile.getStatus());
            System.out.println("------------------------------------------");

            // 3. Створення об'єкта за допомогою параметризованого конструктора
            System.out.println("3. Створення індукційної плитки:");
            Burner inductionBurner = new Burner(22.0);
            HeatingElement inductionElement = new HeatingElement("Індукційний", 850);
            ControlKnob inductionKnob = new ControlKnob(12);
            CookingTile inductionTile = new CookingTile("ElectroLux Pro", inductionBurner, inductionElement, inductionKnob);
            
            System.out.println(inductionTile.getStatus());
            System.out.println("Модель: " + inductionTile.getModelName());
            System.out.println(inductionTile.getHeatingElementInfo());
            inductionTile.turnOn();
            inductionTile.setPowerLevel(10);
            System.out.println(inductionTile.getStatus());
            System.out.println("------------------------------------------");

            // 4. Створення копії об'єкта
            System.out.println("4. Створення копії індукційної плитки:");
            CookingTile copiedTile = new CookingTile(inductionTile);
            System.out.println("Оригінал: " + inductionTile.getModelName() + " | Копія: " + copiedTile.getModelName());
            System.out.println(copiedTile.getStatus());
            copiedTile.turnOn();
            copiedTile.decreasePower(); // Спроба змінити потужність (буде невдалою, бо рівень 0)
            System.out.println(copiedTile.getStatus());

            logger.log("--- Демонстрація роботи програми завершена ---");

        } catch (Exception e) {
            System.err.println("Виникла помилка під час виконання програми: " + e.getMessage());
        }
        
        System.out.println("\nРоботу програми завершено. Перевірте файл log.txt");
    }
}