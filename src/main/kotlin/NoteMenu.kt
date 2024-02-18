import java.lang.IndexOutOfBoundsException
import java.util.InputMismatchException
import java.util.Scanner

open class NoteMenu() : SelectionMenu() {
    override val menu: MutableList<String> =
        mutableListOf("Создать заметку", "Выход в меню Архивов")
    override var chosenNumber: Int = 0
    private val noteMap: MutableMap<String, ExactNoteMenu> = HashMap()

    override fun showMenu() {
        while (true) {
            println("Список Заметок. Введи цифру из предложенных вариантов:")
            super.showMenu()
            when (chosenNumber) {
                0 -> {
                    println("Введите название:")
                    val inputNoteName: String = Scanner(System.`in`).nextLine()
                    if (inputNoteName.isEmpty()) {
                        println("Имя заметки не может быть пустым")
                    } else {
                        menu.add(inputNoteName)
                        noteMap[inputNoteName] = ExactNoteMenu()
                    }

                }

                1 -> break
                in 2..menu.size -> {
                    try {
                        noteMap[menu[chosenNumber]]?.showMenu()
                    } catch (e: IndexOutOfBoundsException) {
                        println("Такого числа нет на экране")
                    }
                }

                else -> continue
            }
        }
    }
}