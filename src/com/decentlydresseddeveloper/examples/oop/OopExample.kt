package com.decentlydresseddeveloper.examples.oop

interface Shape {
    fun doubleArea(): Shape
    fun halveArea(): Shape
}

class Square(private val width: Double) : Shape {
    private val area: Double get() = width * width

    override fun doubleArea(): Shape {
        return withArea(area * 2)
    }

    override fun halveArea(): Shape {
        return withArea(area / 2)
    }

    private fun withArea(area: Double): Shape {
        return Square(width = Math.sqrt(area))
    }
}

class Circle(private val diameter: Double) : Shape {
    private val area: Double
        get() {
            val radius = diameter / 2
            return Math.PI * Math.pow(radius, 2.0)
        }

    override fun doubleArea(): Shape {
        return withArea(area * 2)
    }

    override fun halveArea(): Shape {
        return withArea(area / 2)
    }

    private fun withArea(area: Double): Circle {
        val newRadius = Math.sqrt(area / Math.PI)
        return Circle(diameter = newRadius  * 2)
    }
}

class BigShapeLover {
    fun doYourThing(shape: Shape): Shape {
        return shape.doubleArea()
    }
}

class LittleShapeLover {
    fun doYourThing(shape: Shape): Shape {
        return shape.halveArea()
    }
}
