package com.evolutionnext.scala.study
import org.specs2.{Specification, ScalaCheck}
import org.specs2.specification.gen.{Then, When, Given}
import org.scalacheck.Arbitrary

class EmployeeGWTAcceptanceWithScalaCheck extends Specification with ScalaCheck { def is =
  "An employee given-when-then example"                                        ^
                                                                               p^
  "Given a first name 'a' And given a last name of 'b'"                        ^ firstName ^
  "When I create an Employee using a and b"                                    ^ create ^
  "Then I should get an Employee with name concatenating a b"                  ^ result ^
                                                                               end
  object firstName extends Given[(String, String)] {
    def extract(text: String) = for {
      x <- Arbitrary.arbitrary[String]
      if x.trim.nonEmpty
      y <- Arbitrary.arbitrary[String]
    } yield (x,y)
  }

  object create extends When[(String, String), Employee] {
    def extract(names:(String, String), text: String) = new Employee(names._1, names._2)
  }

  object result extends Then[Employee] {
    def extract(text: String)(implicit emp:Arbitrary[Employee]) = {
      check{(emp:Employee) => emp.fullName must_== (emp.firstName + " " + emp.lastName)}
    }
  }
}
