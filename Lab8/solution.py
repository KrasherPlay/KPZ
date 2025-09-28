# file: solution.py
from math import tan
import struct

# Основна функція обчислення
# @filenameResultTxt - текстовий файл для запису результату
# @filenameResultBin - двійковий файл для запису результату
def solution(filenameResultTxt, filenameResultBin):
    try:
        # Ввід даних користувачем
        x = float(input("Ця програма обчислює y = ctg(8x) / x\nВведіть x: "))

        # Перевірка, щоб уникнути ділення на нуль
        if x == 0:
            print("Помилка: x не може дорівнювати 0 (ділення на нуль).")
            return
        
        # Обчислення ctg(8x)/x
        y = (1 / tan(8 * x)) / x

        # Запис у текстовий файл
        with open(filenameResultTxt, "a", encoding="utf-8") as file:
            file.write(f"Результат функції y=ctg(8x)/x при x={x} дорівнює {y}\n")

        # Запис у двійковий файл (float - 4 байти)
        with open(filenameResultBin, "ab") as file:
            file.write(struct.pack("f", y))

        print(f"Результат успішно збережено у файли {filenameResultTxt} та {filenameResultBin}")

    except Exception as e:
        print(f"Виникла помилка: {e}")


# Функція для читання текстового файлу
def read_txt(filename):
    try:
        with open(filename, "r", encoding="utf-8") as file:
            return file.read()
    except FileNotFoundError:
        return "Файл не знайдено."


# Функція для читання двійкового файлу
def read_binary(filename):
    print(f"\nВміст двійкового файлу {filename}:")
    try:
        with open(filename, "rb") as file:
            while True:
                data = file.read(4)  # читаємо по 4 байти (тип float)
                if not data or len(data) < 4:
                    break
                number = struct.unpack("f", data)[0]
                print(number)
    except FileNotFoundError:
        print("Файл не знайдено.")
