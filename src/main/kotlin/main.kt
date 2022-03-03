import example.myapp.Aquarium
import java.util.*

// all worked from google code labs kotlin bootcamp for programmers: functions

fun main(args: Array<String>) {
    println("Hello World!")

    fun printHello() {
        println("Hello Kotlin!")
    }

    printHello()

    val isUnit = println("This is an expression");

    println(isUnit);

    val temp = 10
    val isHot = if (temp > 50) true else false
    println(isHot)

    val message = "The water temperature is ${ if (temp > 50) "too warm" else "fine"}"
    println(message)

    fun randomDay() : String {
        val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday")
        return week[Random().nextInt(week.size)]
    }

    fun fishFood (day : String) : String {
        var food = ""
        when (day) {
            "Monday" -> food = "flakes"
            "Tuesday" -> food = "pellets"
            "Wednesday" -> food = "redworms"
            "Thursday" -> food = "granules"
            "Friday" -> food = "mosquitoes"
            "Saturday" -> food = "lettuce"
            "Sunday" -> food = "plankton"
            else -> food = "nothing"
        }
        return food
    }

    fun isTooHot(temperature: Int) = temperature > 30

    fun isDirty(dirty: Int) = dirty > 30

    fun isSunday(day: String) = day == "Sunday"

    fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
        return when {
            isTooHot(temperature) -> true
            isDirty(dirty) -> true
            isSunday(day) -> true
            else  -> false
        }
    }

    fun feedTheFish() {
        val day = randomDay()
        val food = fishFood(day)

        println ("Today is $day and the fish eat $food")
        println("Change water: ${shouldChangeWater(day)}")
    }

    feedTheFish()


    fun swim(speed: String = "fast") {
        println("swimming $speed")
    }

    swim()
    swim("slow")
    swim(speed="turtle-like")


    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")



    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }


    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")



    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")


    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}

    println(waterFilter(dirtyLevel))
    println(updateDirty(30, waterFilter))

    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))

    dirtyLevel = 19;
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)


    fun buildAquarium() {
        val aquarium1 = Aquarium()
        aquarium1.printSize()
        // default height and length
        val aquarium2 = Aquarium(width = 25)
        aquarium2.printSize()
        // default width
        val aquarium3 = Aquarium(height = 35, length = 110)
        aquarium3.printSize()
        // everything custom
        val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
        aquarium4.printSize()

        val aquarium6 = Aquarium(numberOfFish = 29)
        aquarium6.printSize()
        aquarium6.volume = 70
        aquarium6.printSize()
        println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")

        val myAquarium = Aquarium(width = 25, length = 25, height = 40)
        myAquarium.printSize()
        val myTower = Aquarium.TowerTank(diameter = 25, height = 40)
        myTower.printSize()
    }

    buildAquarium()

}