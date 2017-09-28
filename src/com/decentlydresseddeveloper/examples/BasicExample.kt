package com.decentlydresseddeveloper.examples

data class SomethingClass(private val someValue: Int, private val anotherValue: Int) {
    fun someOperation(operand: Int): SomethingClass {
        return this.copy(someValue = someValue * operand)
    }
}

data class SomethingData(val someValue: Int, val anotherValue: Int)

class SomethingService {
    fun someOperation(something: SomethingData, operand: Int): SomethingData {
        return something.copy(someValue = something.someValue * operand)
    }
}