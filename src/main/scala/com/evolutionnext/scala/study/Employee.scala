package com.evolutionnext.scala.study

case class Employee(firstName:String, lastName:String, ssn:String) {
  require (firstName.trim() != "")
  def setFirstName (firstName:String):Employee = new Employee(firstName, this.lastName, this.ssn)
  def this(firstName:String, lastName:String) = this(firstName, lastName, "000-00-0000")
  def fullName = firstName + " " + lastName
}
