# file: main.py
import solution

# Імена файлів для збереження результатів
txtFile = "Lab8/result.txt"
binFile = "Lab8/result.bin"

# Виклик основної функції
solution.solution(txtFile, binFile)

# Вивід вмісту текстового файлу
print(f"\nВміст файлу {txtFile}:")
print(solution.read_txt(txtFile))

# Вивід вмісту двійкового файлу
solution.read_binary(binFile)
