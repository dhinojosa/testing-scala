package com.evolutionnext.scala.study

import org.specs2.mutable._

class EmployeeUnitSpecification extends Specification {
  "An employee" should {
    "return the same first name and last given to it's constructor" in {
      val emp = new Employee("Lex", "Luthor")
      emp.firstName must be("Lex")
      emp.lastName must be("Luthor") //Different matcher methods for specs
    }

    "throw IllegalArgumentException if an empty string is given as a first name" in {
      new Employee("", "Luthor") must throwA[IllegalArgumentException]
    }

    "make me money" ! pending
  }
}