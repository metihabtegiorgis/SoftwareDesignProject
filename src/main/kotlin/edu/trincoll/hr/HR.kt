package edu.trincoll.hr

class HR(private val employees: List<Employee> = emptyList()) {

    //Method to hire a new employee
    fun hire(employee: Employee) : HR {
        val currEmployees = employees + employee
        return HR(currEmployees)
    }
    //Method to fire an employee
    fun fire(id: Int): HR{
        val currEmployees = employees.filter{ it.id != id}
        return HR(currEmployees)
    }
    //Method to calculate the total pay of the employees
    fun payEmployees() : Double {
        return employees.sumOf{ it.pay() }
    }

}