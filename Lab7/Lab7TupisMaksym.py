import sys

def generate_shaded_array(size: int, fill_char: str) -> list[list[str]]:
    """
    Генерує "зубчатий" масив у формі перевернутого трикутника.

    Args:
        size (int): Розмір матриці.
        fill_char (str): Символ для заповнення.

    Returns:
        list[list[str]]: Згенерований зубчатий масив.
    """
    jagged_array = []
    mid_row = (size + 1) // 2
    for i in range(size):
        if i < mid_row:
            count = size - 2 * i
            row = [fill_char] * count
            jagged_array.append(row)
        else:
            jagged_array.append([])
    return jagged_array

def print_array_to_console(array: list[list[str]]):
    """
    Виводить масив на консоль, центрує кожен рядок.

    Args:
        array (list[list[str]]): Масив для виведення.
    """
    size = len(array)
    for row in array:
        padding = (size - len(row)) // 2
        print("  " * padding, end="")
        print(" ".join(row))

def main():
    """
    Основна функція програми.
    """
    try:
        size_input = input("Введіть розмір квадратної матриці (n > 0): ")
        if not size_input.isdigit():
            print("Помилка: Розмір матриці має бути цілим числом.", file=sys.stderr)
            return

        size = int(size_input)
        if size <= 0:
            print("Помилка: розмір матриці має бути додатнім числом.", file=sys.stderr)
            return

        fill_char = input("Введіть один символ-заповнювач: ")
        if len(fill_char) != 1:
            print("Помилка: потрібно ввести рівно один символ.", file=sys.stderr)
            return

        # --- Генерація та вивід масиву ---
        shaded_array = generate_shaded_array(size, fill_char)

        print("\nЗгенерований зубчатий масив:")
        print_array_to_console(shaded_array)

    except Exception as e:
        print(f"Сталася помилка під час виконання програми: {e}", file=sys.stderr)

if __name__ == "__main__":
    main()