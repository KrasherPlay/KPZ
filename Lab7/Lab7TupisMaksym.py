import sys

def generate_filled_array(size: int, fill_char: str, padding_char: str) -> list[list[str]]:
    if size <= 0:
        return []
    array = []
    mid_row = (size + 1) // 2
    for i in range(mid_row):
        row = [padding_char] * size 
        fill_count = size - 2 * i
        start_index = i
        for j in range(fill_count):
            row[start_index + j] = fill_char     
        array.append(row)    
    return array

def print_array_to_console(array: list[list[str]]):
    for row in array:
        print(" ".join(row))

def main():
    try:
        size_input = input("Введіть розмір квадратної матриці (n > 0): ")
        if not size_input.isdigit():
            print("Помилка: Розмір матриці має бути цілим числом.", file=sys.stderr)
            return

        size = int(size_input)
        if size <= 0:
            print("Помилка: розмір матриці має бути додатнім числом.", file=sys.stderr)
            return

        fill_char = input("Введіть один символ для фігури: ")
        if len(fill_char) != 1:
            print("Помилка: потрібно ввести рівно один символ.", file=sys.stderr)
            return
            
        padding_char = "."
        # --- Генерація та вивід масиву ---
        filled_array = generate_filled_array(size, fill_char, padding_char)

        print("\nЗгенерований заповнений масив:")
        print_array_to_console(filled_array)
    except Exception as e:
        print(f"Сталася помилка під час виконання програми: {e}", file=sys.stderr)

if __name__ == "__main__":
    main()