import java.util.Scanner

class ExactNoteMenu : SelectionMenu() {
    override val menu: MutableList<String> =
        mutableListOf("Ввод текста заметки", "Выход в меню Заметок", "Просмотр текста заметки")
    override var chosenNumber: Int = 0
    var exactText: String = ""

    override fun showMenu() {
        while (true) {
            println("Просмотр заметки. Введи цифру из предложенных вариантов:")
            super.showMenu()
            when (chosenNumber) {
                0 -> {
                    println("Введите текст:")
                    val inputExactNoteName: String = Scanner(System.`in`).nextLine()
                    if (inputExactNoteName.isEmpty()) {
                        println("Текст не может быть пустым")
                    } else {
                        exactText = inputExactNoteName
                    }
                }

                1 -> break
                2 -> {
                    println("$exactText \nЕсли хочешь выйти из режима просмотра, введи любой символ")
                    Scanner(System.`in`).nextLine()
                }

                else -> {
                    println("Такого числа нет на экране")
                    continue
                }
            }
        }
    }
}