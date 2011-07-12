package com.evolutionnext.scala.study

import org.scalacheck.Prop._
import org.scalacheck.Properties

object EmployeeScalaCheck extends Properties("Employee") {

  property("fullNameWithNoEmptyString") = forAll {(a: String, b: String) =>
      ((!a.isEmpty) && (!b.isEmpty)) ==> {
          new Employee(a, b).fullName == a.trim() + " " + b.trim()
      }
  }    
}