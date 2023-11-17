fun main() {
    println("Введите элементы массива через запятую: ")
    val input = readLine() // Считываем ввод пользователя
    val words = input?.split(",")?.map { it.trim() } // Разбиваем ввод на массив слов

    if (words != null) {
        val groupedWords = groupWordsByLetters(words)
        printGroupedWords(groupedWords)
    } else {
        println("Ошибка ввода")
    }
}

fun groupWordsByLetters(words: List<String>): Map<String, List<String>> {
    val groupedWords = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("") // Сортируем буквы в слове
        if (groupedWords.containsKey(sortedWord)) {
            groupedWords[sortedWord]?.add(word) // Добавляем слово в существующую группу
        } else {
            groupedWords[sortedWord] = mutableListOf(word) // Создаем новую группу слов
        }
    }

    return groupedWords
}

fun printGroupedWords(groupedWords: Map<String, List<String>>) {
    for ((key, value) in groupedWords) {
        println("$value")
    }
}