package com.evolutionnext.scala.study

import org.scalatest.Spec
import org.scalatest.matchers.MustMatchers
import scala.collection.mutable.Stack

class EmployeeTestWithBDD extends Spec with MustMatchers {
  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      stack.pop() must be === 2
      stack.pop() must be === 1
    }

    it("should throw NoSuchElementException if an empty stack is popped") {
      val emptyStack = new Stack[String]
      evaluating {emptyStack.pop()} must produce[NoSuchElementException]
    }
  }

  describe("An Employee") {
    it ("must return the first name and last name given at construction time") {
      val emp = new Employee("Dan", "Merk")
      emp.firstName must be === "Dan"
      emp.lastName must be === "Merk"
    }
  }
}
