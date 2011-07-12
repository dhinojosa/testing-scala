package com.evolutionnext.scala.study

import org.testng.annotations.Test
import org.scalatest.testng.TestNGSuite
import org.scalatest.matchers.MustMatchers

class EmployeeTestWithTestNG extends TestNGSuite with MustMatchers {
  @Test()
  def testCreationOfEmployeeObjectAndProperties() {
    val emp = new Employee("Lex", "Luthor")
    emp.firstName must equal("Lex")
    emp.firstName must include regex ("L.x")
    emp.lastName must include regex ("L.*r") 
  }
}


