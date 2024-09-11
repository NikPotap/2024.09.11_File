import java.io.File
import java.io.FileReader
import java.io.FileWriter

fun main() {
// 1.
    println("1. Пишем что-то в файл и читаем из него.\n")
    val newfile = File("C:/Docs.tmp/мой тестовый файл.txt")
    val fileWriter = FileWriter(newfile)
    fileWriter.write("Записали что-то в файл.")
    fileWriter.close()
    val fileReader = FileReader(newfile)
    println("Данные из созданного файла:\n${fileReader.readText()}")
    fileReader.close()
// 2.
    println("\n2. Запись чисел в файл.\n")
    val path = "C:/Docs.tmp"
    val fileName = "numbers.txt"
    val numbersQuantity = 7
    val numbersFile = File(path + "/" + fileName)
    val anotherWriter = FileWriter(numbersFile)
    val maxNumber = numbersQuantity * 2
    for (i in 2..maxNumber step 2) {
        anotherWriter.write(i.toString())
        if (i < maxNumber) anotherWriter.write(",")
    }
    anotherWriter.close()
    val anotherReader = FileReader(numbersFile)
    println("Создан файл с последовательносью чисел:\n${anotherReader.readText()}")
    anotherReader.close()
// 3.
    println("\n3. Достаём числа из файла.\n")
    val integerNumbersFile = File("C:/Docs.tmp/файл целых чисел.txt")
    val integersReader = FileReader(integerNumbersFile)
    val integersList = integersReader.readText().split(",")
    val listIndicies: List<Int> = listOf(0, 1, integersList.size - 2, integersList.size - 1)
    println("Первый, второй, предпоследний и последний элементы списка в файле:")
    for (i: Int in listIndicies) println(integersList[i])
}