package io.inklot.muskt

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class QuantityTest : FunSpec({
    test("I can create quantities") {
        val distance: Quantity<Metres> = 5.to<Metres>()
        val time: Quantity<Seconds> = 5.to<Seconds>()
    }

    test("I can add objects of the same unit") {
        val distance: Quantity<Metres> = 5.to<Metres>()
        (distance + distance).double shouldBe 10
    }

    test("I can substract objects of the same unit") {
        val distance: Quantity<Metres> = 5.to<Metres>()
        (distance - distance).double shouldBe 0
    }

    test("multiplying objects multiplies it") {
        val distance = 5.to<Metres>()
        val area: Quantity<Mul<Metres, Metres>> = distance * distance
    }

    test("dividing objects divides them") {
        val distance = 5.to<Metres>()
        val time = 1.to<Seconds>()
        val speed: Quantity<Div<Metres, Mul<Seconds, Seconds>>> = distance / (time * time)
    }

    test("one can raise to an integer power") {
        val distance = 5.to<Metres>()
        val area: Quantity<Mul<Metres, Metres>> = distance.pow(2)
    }

    test("one can raise to a double power") {
        val distance = 5.to<Metres>()
        val area: Quantity<Mul<Metres, Metres>> = distance.pow(2.4)
    }
})