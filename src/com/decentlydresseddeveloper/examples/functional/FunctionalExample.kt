package com.decentlydresseddeveloper.examples.functional

sealed class Shape
data class Square(val width: Double) : Shape()
data class Circle(val diameter: Double) : Shape()

fun doBigShapeLoversThing(shape: Shape): Shape {
    return when (shape) {
        is Square -> doubleAreaOfSquare(shape)
        is Circle -> doubleAreaOfCircle(shape)
    }
}

fun doSmallShapeLoversThing(shape: Shape): Shape {
    return when (shape) {
        is Square -> halveAreaOfSquare(shape)
        is Circle -> halveAreaOfCircle(shape)
    }
}

private fun doubleAreaOfSquare(square: Square): Square {
    return squareWithArea(areaOfSquare(square) * 2)
}

private fun doubleAreaOfCircle(circle: Circle): Circle {
    return circleWithArea(areaOfCircle(circle) * 2)
}

private fun halveAreaOfSquare(square: Square) =
        squareWithArea(areaOfSquare(square) / 2)

private fun halveAreaOfCircle(circle: Circle) =
        circleWithArea(areaOfCircle(circle) / 2)

private fun areaOfSquare(square: Square): Double {
    return square.width * square.width
}

private fun areaOfCircle(circle: Circle): Double {
    val radius = circle.diameter / 2
    return Math.PI * Math.pow(radius, 2.0)
}

private fun circleWithArea(area: Double): Circle {
    val newRadius = Math.sqrt(area / Math.PI)
    return Circle(diameter = newRadius * 2)
}

private fun squareWithArea(area: Double): Square {
    val newWidth = Math.sqrt(area)
    return Square(width = newWidth)
}
