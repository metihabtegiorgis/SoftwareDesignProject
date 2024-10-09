package edu.trincoll.hr

class Salaried(
    name: String,
    id: Int,
    private val salary: Double
) : Employee(name, id) {

    //Override the pay method
    override fun pay(): Double {
        return salary/26.0
    }
    //Override the toString method
    override fun toString(): String {
        return "Salaried(name=$name, id=$id, salary=$salary)"
    }
}