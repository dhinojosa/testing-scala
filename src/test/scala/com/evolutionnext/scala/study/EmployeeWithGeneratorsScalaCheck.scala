package com.evolutionnext.scala.study

import org.scalacheck.Prop._
import org.scalacheck.{Gen, Properties}

object EmployeeWithGeneratorsScalaCheck extends Properties("Employee") {
  val gen1 = Gen.oneOf("Abigail", "Amber", "Bertha", "Cally", "Diana", "Esther", "Frannie", "Texarkana", "Justine")
  val gen2 = Gen.oneOf("Adams", "Valles", "Simons", "Gomez", "Patel", "Mehra", "Groenfeld", "Thatcher", "Greenfield")

  property("fullNameWithNoEmptyString") = forAll(gen1, gen2) {
    (a: String, b: String) => new Employee(a, b).fullName == a.trim() + " " + b.trim()
  }
}