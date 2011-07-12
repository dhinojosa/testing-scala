package com.evolutionnext.scala.study

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.matchers.MustMatchers
import org.scalatest.WordSpec

class ScalaTestWithChecks extends WordSpec with GeneratorDrivenPropertyChecks with MustMatchers {
  "fullName" should {
    "return the concatenation of both first name and last name given a battery of Strings" in {
      forAll {
        (a: String, b: String) =>
          whenever((!a.isEmpty) && (!b.isEmpty)) {
            new Employee(a, b).fullName == a.trim() + " " + b.trim()
          }
      }
    }
  }
}