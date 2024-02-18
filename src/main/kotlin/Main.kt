import java.lang.IndexOutOfBoundsException
import java.util.InputMismatchException
import java.util.Scanner

//val scanner = Scanner(System.in)
fun main(args: Array<String>) {
    val archiveMenu = ArchiveMenu()
    archiveMenu.showMenu()
}

open class SelectionMenu() {
    open val menu: MutableList<String> = mutableListOf()
    open var chosenNumber: Int = 0

    open fun showMenu() {
        menu.forEachIndexed { index, element -> println("${index}. $element") }
        chosenNumber = try {
            Scanner(System.`in`).nextLine().toInt()
        } catch (e: NumberFormatException) {
            println("Прости, но без целых чисел никуда. Откатываемся к предыдущему состоянию")
            1
        }
    }
}