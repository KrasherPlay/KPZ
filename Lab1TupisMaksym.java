import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ця програма генерує зубчатий масив, що представляє заштриховану область
 * квадратної матриці, виводить його на екран та зберігає у файл.
 * Розмір матриці та символ-заповнювач вводяться користувачем.
 *
 * @author ВашеІм'я ВашеПрізвище
 * @version 1.0
 */
public class Lab1TupisMaksym {

    /**
     * Головний метод, який є точкою входу в програму.
     * Він керує отриманням даних від користувача, генерацією масиву,
     * виведенням на екран та записом у файл.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // --- Введення розміру матриці ---
            System.out.print("Введіть розмір квадратної матриці (n > 0): ");
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Помилка: розмір матриці має бути додатнім числом.");
                return; 
            }
            scanner.nextLine(); // Споживаємо залишок рядка після nextInt()

            // --- Введення символу-заповнювача ---
            System.out.print("Введіть один символ-заповнювач: ");
            String inputChar = scanner.nextLine();

            // Перевірка коректності введеного символу
            if (inputChar.length() != 1) {
                System.out.println("Помилка: потрібно ввести рівно один символ.");
                return; 
            }
            char fillChar = inputChar.charAt(0);

            // --- Генерація та вивід масиву ---
            char[][] shadedArray = generateShadedArray(size, fillChar);

            System.out.println("\nЗгенерований зубчатий масив:");
            printArrayToConsole(shadedArray);

            writeArrayToFile(shadedArray, "output.txt");
            System.out.println("\nМасив успішно збережено у файл output.txt");

        } catch (Exception e) {
            System.out.println("Сталася помилка під час введення даних. Будь ласка, перевірте правильність вводу.");
            // e.printStackTrace(); // Розкоментуйте для налагодження
        } finally {
            scanner.close(); // Закриваємо сканер для уникнення витоку ресурсів
        }
    }

    /**
     * Генерує зубчатий масив для ВАРІАНТУ: рівнобедрений трикутник зверху.
     * <p>
     *
     * @param size      Розмір вихідної квадратної матриці.
     * @param fillChar  Символ для заповнення масиву.
     * @return Двовимірний зубчатий масив, що представляє трикутник.
     */
    public static char[][] generateShadedArray(int size, char fillChar) {
        // Кількість рядків у трикутнику дорівнює половині розміру матриці (округлено вгору)
        int numRows = (size + 1) / 2;
        char[][] jaggedArray = new char[numRows][];

        // Ітеруємо тільки по рядках, що увійдуть до трикутника
        for (int i = 0; i < numRows; i++) {
            // Кількість елементів у поточному рядку: size, size-2, size-4, ...
            int numElements = size - 2 * i;
            jaggedArray[i] = new char[numElements];

            // Заповнюємо рядок символами
            for (int j = 0; j < numElements; j++) {
                jaggedArray[i][j] = fillChar;
            }
        }
        return jaggedArray;
    }

    /**
     * Виводить вміст зубчатого масиву на консоль.
     *
     * @param array Масив, який потрібно вивести.
     */
    public static void printArrayToConsole(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            // Додаємо відступи для візуального вирівнювання (як у матриці)
            for (int k = 0; k < i; k++) {
                System.out.print("  "); // Два пробіли для імітації одного символу
            }
            // Виводимо елементи рядка
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок
        }
    }

    /**
     * Записує вміст зубчатого масиву у текстовий файл.
     *
     * @param array    Масив, який потрібно записати.
     * @param filename Ім'я файлу для збереження.
     */
    public static void writeArrayToFile(char[][] array, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < array.length; i++) {
                // Логіка для запису аналогічна виводу на консоль
                for (int k = 0; k < i; k++) {
                    writer.write("  ");
                }
                for (int j = 0; j < array[i].length; j++) {
                    writer.write(array[i][j] + " ");
                }
                writer.write(System.lineSeparator()); // Додаємо символ нового рядка
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл: " + e.getMessage());
        }
    }
}