package edu.trincoll.hr

class Hourly (
    name: String,
    id: Int,
    private val rate: Double,
    private val hours: Double = 80.00,
) : Employee(name, id) {

    //Overriding the pay function
    override fun pay(): Double {
        return rate*hours
    }
    //Overriding the toString function
    override fun toString(): String {
        return "Hourly(name=$name, id=$id, rate=$rate, hours=$hours)"
    }
}