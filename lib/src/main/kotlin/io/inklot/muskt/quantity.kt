package io.inklot.muskt

import kotlin.math.pow

interface Dimension
interface Length : Dimension
interface Mass : Dimension
interface Time : Dimension

sealed interface Measure

interface Units<DimensionType : Dimension> : Measure
interface Metres : Units<Length>
interface Kilograms : Units<Mass>
interface Seconds : Units<Time>

fun <A : Measure> Number.to(): Quantity<A> {
    return Quantity<A>(this.toDouble())
}

interface BinOp<A: Measure, B: Measure>: Measure
interface Mul<A: Measure, B: Measure>: BinOp<A, B>
interface Div<A: Measure, B: Measure>: BinOp<A, B>

@JvmInline
value class Quantity<out Units : Measure>(val double: Double)

operator fun <A: Measure> Quantity<A>.plus(that: Quantity<A>): Quantity<A> {
    return Quantity<A>(this.double + that.double)
}

operator fun <A: Measure> Quantity<A>.minus(that: Quantity<A>): Quantity<A> {
    return Quantity<A>(this.double - that.double)
}

operator fun <A: Measure, B: Measure> Quantity<A>.times(that: Quantity<B>): Quantity<Mul<A, B>> {
    return Quantity<Mul<A, B>>(this.double * that.double)
}

operator fun <A: Measure, B: Measure> Quantity<A>.div(that: Quantity<B>): Quantity<Div<A, B>> {
    return Quantity<Div<A, B>>(this.double / that.double)
}

fun <A: Measure> Quantity<A>.pow(i: Int): Quantity<Mul<A, A>> {
    val double1 = this.double.pow(i)
    return Quantity<Mul<A, A>>(double1)
}

fun <A: Measure> Quantity<A>.pow(i: Double): Quantity<Mul<A, A>> {
    val double1 = this.double.pow(i)
    return Quantity<Mul<A, A>>(double1)
}