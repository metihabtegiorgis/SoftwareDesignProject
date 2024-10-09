package edu.trincoll.hr

abstract class Employee(
    val name: String,
    val id: Int
) : Comparable<Employee> {

    //Override the compareTo method in Comparable
    override fun compareTo(other: Employee): Int {
        val payComparison = this.pay().compareTo(other.pay())
        if (payComparison != 0) {
            return payComparison
        }

        val nameComparison = name.compareTo(other.name)
        if (nameComparison != 0) {
            return nameComparison
        }

        return id.compareTo(other.id)
    }
    //Override the toString method
    override fun toString(): String {
        return "$name, $id"
    }
    //Abstract method to calculate pay
    abstract fun pay(): Double


}