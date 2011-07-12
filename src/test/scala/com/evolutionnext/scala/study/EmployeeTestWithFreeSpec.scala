package com.evolutionnext.scala.study

import org.scalatest.matchers.MustMatchers
import org.scalatest.FreeSpec

class EmployeeTestWithFreeSpec extends FreeSpec with MustMatchers {
  "An Employee" - {
    "is a curious thing" - {
      "they do what you tell them to, up to a certain point, and that point is 5PM" - {
        """but I digress, if you give it a firstName and lastName, the fullName should be
                the concactenation of both""" in {
          val emp = new Employee("Lex", "Luthor")
          emp.firstName must equal("Lex")
          emp.lastName must equal("Luthor")
        }
      }
    }
  }
}