import java.lang.IndexOutOfBoundsException
import java.util.Scanner

class ArchiveMenu : SelectionMenu() {
    override val menu: MutableList<String> = mutableListOf("Создать архив", "Выход из программы")
    override var chosenNumber: Int = 0

    //private val noteMenu = NoteMenu()
    private val archivesMap: MutableMap<String, NoteMenu> = HashMap()
    override fun showMenu() {
        while (true) {
            println("Список Архивов. Введи цифру из предложенных вариантов:")
            super.showMenu()
            when (chosenNumber) {
                0 -> {
                    println("Введите название:")
                    val inputArchiveName: String = Scanner(System.`in`).nextLine()
                    if (inputArchiveName.isEmpty()) {
                        println("Название не может быть пустым")
                    } else {
                        menu.add(inputArchiveName)
                        archivesMap[inputArchiveName] = NoteMenu()
                    }
                }

                1 -> break
                in 2..menu.size -> {
                    try {
                        archivesMap[menu[chosenNumber]]?.showMenu()
                    } catch (e: IndexOutOfBoundsException) {
                        println("Такого числа нет на экране")
                    }
                }

                else -> continue
            }
        }
    }
}