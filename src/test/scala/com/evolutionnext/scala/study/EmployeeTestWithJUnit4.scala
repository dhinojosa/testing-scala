package com.evolutionnext.scala.study

import org.junit.Test
import org.scalatest.junit.{JUnitSuite}
import org.scalatest.matchers.MustMatchers

class EmployeeTestWithJUnit4 extends JUnitSuite with MustMatchers  {

  @Test def testCreationOfEmployeeObjectAndProperties() {
    val emp = new Employee("Lex", "Luthor")
    emp.firstName must equal("Lex")
    emp.firstName must include regex ("L.x")
    emp.lastName must include regex ("L.*r") // success!
  }
}