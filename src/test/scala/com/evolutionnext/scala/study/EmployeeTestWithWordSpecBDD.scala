package com.evolutionnext.scala.study

import org.scalatest.matchers.MustMatchers

import org.scalatest.WordSpec

class EmployeeTestWithWordSpecBDD extends WordSpec with MustMatchers {
  "An Employee" should {

    "return the same first name and last given to it's constructor" in {
      val emp = new Employee("Lex", "Luthor")
      emp.firstName must equal("Lex")
      emp.lastName must equal("Luthor")
    }

    "throw IllegalArgumentException if an empty string is given as a first name" in {
      intercept[IllegalArgumentException] {
        new Employee("", "Luthor")
      }
    }
  }
}