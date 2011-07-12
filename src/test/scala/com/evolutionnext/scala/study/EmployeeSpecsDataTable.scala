package com.evolutionnext.scala.study

import org.specs2.matcher.DataTables
import org.specs2.mutable.Specification

class EmployeeSpecsDataTable extends Specification with DataTables {
    "Create a battery of first names and last names and validate the full names" in {
       "First Name" | "Last Name"   | "Full Name"          |>
       "Jay"        !! "Zimmerman"   ! "Jay Zimmerman"      |
       "Venkat"     !! "Subramaniam" ! "Venkat Subramaniam" |
       "Ken"        !! "Sipe"        ! "Ken Sipe"           |
       "Tim     "   !! "Berglund"    ! "Tim Berglund"       |
       "Matthew"    !! "McCullough"  ! "Matthew McCullough" |
       "Brian"      !! "   Sletten"  ! "Brian Sletten"      |
       { (firstName, lastName, fullName) =>
            val emp = new Employee(firstName, lastName)
            emp.fullName must_== fullName
       }
   }
}