
 // COMP2850 Portfolio: Week 4
 // ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {

    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size

    val notStarted get() = items.count {
        it.status == ItemStatus.NotStarted
    }

    val inProgress get() = items.count {
        it.status == ItemStatus.InProgress
    }

    val done get() = items.count {
        it.status == ItemStatus.Done
    }

    val overdue get() = items.count {
        it.isOverdue()
    }

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {
        val loadedItems = mutableListOf<ToDoItem>()

        Path(filename).forEachLine { line ->
            if (line.isNotBlank()) {
                val parts = if (line.contains(": ")) {
                    line.split(": ", limit = 3)
                } else {
                    line.split(",", limit = 3)
                }

                require(parts.size == 3) {
                    "Invalid ToDoItem format: $line"
                }

                val dueDate = LocalDate.parse(parts[0].trim())
                val status = ItemStatus.valueOf(parts[1].trim())
                val description = parts[2].trim()

                loadedItems.add(
                    ToDoItem(dueDate, status, description)
                )
            }
        }

        items.clear()
        items.addAll(loadedItems)
    }

    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) =
        item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        return items.removeAll {
            it.status == ItemStatus.Done
        }
    }

    fun getItems(
        status: ItemStatus? = null
    ): List<ToDoItem> {
        return items.filter {
            status == null || it.status == status
        }
    }

    fun getItemsDueOn(
        date: LocalDate
    ): List<ToDoItem> {
        return items.filter {
            it.dueDate == date
        }
    }
}
