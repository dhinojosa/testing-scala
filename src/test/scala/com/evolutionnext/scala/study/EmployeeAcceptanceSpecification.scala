package com.evolutionnext.scala.study

import org.specs2._

class EmployeeAcceptanceSpecification extends Specification {  def is =
  "An employee should"                                                            ^
                                                                                  p^
  "return the same first name and last given to it's constructor"               ! e1^
  "throw IllegalArgumentException if an empty string is given as a first name"  ! e2^
                                                                                  end
  def e1 = {
    val emp = new Employee("Lex", "Luthor")
    emp.firstName must be("Lex")
    emp.lastName must be("Luthor")
  }

  def e2 = { new Employee("", "Luthor") must throwA[IllegalArgumentException] }
}
