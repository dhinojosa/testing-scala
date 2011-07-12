package com.evolutionnext.scala.study

import org.specs2.specification.{Then, When, Given}
import org.specs2.execute.Result
import org.specs2.Specification

class EmployeeGWTAcceptanceSpecification extends Specification { def is =

  "An employee given-when-then example"                                        ^
                                                                               p^
  "Given a blank first name ${Lady}"                                           ^ firstName ^
  "And given a last name of ${Gaga}"                                           ^ lastName ^
  "Then I should get an Employee with name of ${Lady Gaga}"                    ^ result ^
                                                                               end
  object firstName extends Given[String] {
    def extract(text: String): String = extract1(text)
  }

  object lastName extends When[String, Employee] {
    def extract(firstName:String, text:String) = new Employee(firstName, extract1(text))
  }

  object result extends Then[Employee] {
    def extract(employee: Employee, text: String): Result = employee.fullName must_== extract1(text)
  }
}