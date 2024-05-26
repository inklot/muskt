package io.inklot.muskt

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class QuantityTest : FunSpec({
    test("I can create quantities") {
        val distance: Quantity<One, Metres> = 5.to()
        val time: Quantity<One, Seconds> = 5.to()
    }

    test("I can add objects of the same unit") {
        val distance: Quantity<One, Metres> = 5.to()
        (distance + distance) shouldBe 10.to<One, Metres>()
    }

    test("I can substract objects of the same unit") {
        val distance: Quantity<One, Metres> = 5.to()
        (distance - distance) shouldBe 0.to()
    }

    test("multiplying objects multiplies it") {
        val distance = 5.to<One, Metres>()
        val area: Quantity<Two, Metres> = distance * distance
    }
//
//    test("dividing objects divides them") {
//        val distance = 5.to<One, Metres>()
//        val time = 1.to<One, Seconds>()
//        val acceleration: Quantity<Div<Metres, Mul<Seconds, Seconds>>> = distance / (time * time)
//    }
})