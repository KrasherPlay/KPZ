import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Lab1TupisMaksym {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // --- Введення розміру матриці ---
            System.out.print("Введіть розмір квадратної матриці (n > 0): ");
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Помилка: розмір матриці має бути додатнім числом.");
                return; // Завершення програми
            }
            scanner.nextLine(); // Споживаємо залишок рядка після nextInt()

            // --- Введення символу-заповнювача ---
            System.out.print("Введіть один символ-заповнювач: ");
            String inputChar = scanner.nextLine();

            // Перевірка коректності введеного символу
            if (inputChar.length() != 1) {
                System.out.println("Помилка: потрібно ввести рівно один символ.");
                return; // Завершення програми
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

        } finally {
            scanner.close(); // Закриваємо сканер для уникнення витоку ресурсів
        }
    }

    public static char[][] generateShadedArray(int size, char fillChar) {
        char[][] jaggedArray = new char[size][];
        int midRow = (size + 1) / 2; // Рядок, до якого формується трикутник

        for (int i = 0; i < size; i++) {
            if (i < midRow) {
                // Розраховуємо кількість символів у рядку, що зменшується
                // від size до 1 (для непарного розміру) або 2 (для парного)
                int count = size - 2 * i;
                jaggedArray[i] = new char[count];
                for (int j = 0; j < count; j++) {
                    jaggedArray[i][j] = fillChar;
                }
            } else {
                // Решта рядків залишаються порожніми
                jaggedArray[i] = new char[0];
            }
        }
        return jaggedArray;
    }

    public static void printArrayToConsole(char[][] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            // Розраховуємо кількість відступів зліва, щоб вирівняти фігуру по центру
            int padding = (size - array[i].length) / 2;
            for (int k = 0; k < padding; k++) {
                System.out.print("  "); // Два пробіли для імітації одного символу
            }
            
            // Виводимо елементи рядка
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок
        }
    }

    public static void writeArrayToFile(char[][] array, String filename) {
        int size = array.length;
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < size; i++) {
                // Логіка для запису аналогічна виводу на консоль
                int padding = (size - array[i].length) / 2;
                for (int k = 0; k < padding; k++) {
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
