package club.chenzhong.kotlin.paragraph2

data class Country(
        val name: String,
        val continent: String,
        var population: Int
)

class CountryApp {
    fun filterCountries(countries: List<Country>): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (c.continent == "EU") {
                res.add(c)
            }
        }
        return res
    }

    fun filterCountries2(countries: List<Country>, continent: String): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (c.continent == continent) {
                res.add(c)
            }
        }
        return res
    }

    fun filterCountries3(
            countries: List<Country>,
            test: (Country) -> Boolean
    ): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (test(c)) {
                res.add(c)
            }
        }
        return res
    }

    fun filterCountries4(countries: List<Country>, test: (Country) -> Boolean, demo: (String) -> Unit): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (test(c)) {
                res.add(c)
                demo(c.name)
            }
        }
        println("println any $demo")
        return res
    }
}

class CountryTest {
    fun isBigEuropeanCountry(country: Country): Boolean {
        return country.continent == "EU" && country.population > 10000
    }
}

val countryApp = CountryApp()
fun main(args: Array<String>) {
    Boolean
    val cChina = Country("China", "Asia", 14 * 10000 * 10000)
    val cGermany = Country("Germany", "EU", 50 * 10000)
    val copy = cChina.copy()
    cChina.population = 15
    println(copy)
    println("copy === cChina ${cChina === copy}")
    val countries = listOf(cChina, cGermany)
    val list = countryApp.filterCountries2(countries, "Asia")
    println(list)
    val countryTest = CountryTest()
    val countries3 = countryApp.filterCountries3(countries, countryTest::isBigEuropeanCountry)
    println("EU > 10000 counties: \n$countries3")
    val filter2 = countryApp.filterCountries3(countries, fun(country: Country): Boolean {
        return country.continent == "EU" && country.population > 10000
    })
    val filterCountries3 = countryApp.filterCountries3(countries) { country -> country.continent == "EU" && country.population > 10000 }
    println("filter2 is $filter2")
    println("filter3 is $filterCountries3")
    val s = "哈哈"
    val filter4 = countryApp.filterCountries4(countries,
            { country -> country.continent == "EU" && country.population > 10000 },
            { k -> println(k + "123") })
    println("filter4=$filter4")
}

data class Book(val name: String)

fun main2(args: Array<String>): String {
    val bookNames = listOf(
            Book("语文"),
            Book("数学"),
            Book("英语")
    ).map(Book::name)
    println(bookNames)
    val javaClass = bookNames.javaClass
    return ""
}