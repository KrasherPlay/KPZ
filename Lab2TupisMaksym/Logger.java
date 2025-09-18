package Lab2TupisMaksym;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Клас для логування дій програми у файл.
 * Реалізує шаблон Singleton та інтерфейс AutoCloseable.
 */
public class Logger implements AutoCloseable {
    private static Logger instance;
    private final PrintWriter writer;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private Logger(String filename) throws IOException {
        // FileWriter з параметром 'true' для дозапису у файл
        FileWriter fw = new FileWriter(filename, true);
        this.writer = new PrintWriter(fw);
    }

    /**
     * Повертає єдиний екземпляр логера.
     * @return екземпляр Logger
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            try {
                instance = new Logger("log.txt");
            } catch (IOException e) {
                System.err.println("Не вдалося ініціалізувати логер: " + e.getMessage());
                // В реальному додатку тут може бути інша логіка обробки помилок
                throw new RuntimeException("Помилка створення файлу логу", e);
            }
        }
        return instance;
    }

    /**
     * Записує повідомлення у лог-файл з поточною датою та часом.
     * @param message Повідомлення для запису
     */
    public void log(String message) {
        String timestamp = dtf.format(LocalDateTime.now());
        writer.println("[" + timestamp + "] " + message);
        writer.flush(); // Записуємо дані у файл негайно
    }

    /**
     * Закриває PrintWriter для коректного збереження файлу.
     * Цей метод буде автоматично викликаний при використанні try-with-resources.
     */
    @Override
    public void close() {
        if (writer != null) {
            log("Завершення роботи логера та закриття файлу.");
            writer.close();
            instance = null; // Дозволяємо створити новий екземпляр при наступному запуску
        }
    }
}