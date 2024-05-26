package io.inklot.muskt

import kotlin.math.pow

interface Dimension
interface Length : Dimension
interface Mass : Dimension
interface Time : Dimension

sealed interface Measure

interface Units<DimensionType : Dimension> : Measure
interface Metres : Units<Length>
interface Seconds : Units<Time>

fun <Power: Nat<*>, A : Measure> Number.to(): Quantity<Power, A> {
    return Quantity<Power, A>(this.toDouble())
}

@JvmInline
value class Quantity<Power: Nat<*>, Units : Measure>(val double: Double)

operator fun <Power: Nat<*>, A : Measure> Quantity<Power, A>.plus(that: Quantity<Power, A>): Quantity<Power, A> {
    return Quantity(this.double + that.double)
}

operator fun <Power: Nat<*>, A : Measure> Quantity<Power, A>.minus(that: Quantity<Power, A>): Quantity<Power, A> {
    return Quantity(this.double - that.double)
}

operator fun <Power: Nat<*>, A: Measure> Quantity<Power, A>.times(that: Quantity<Power, A>): Quantity<S<Power>, A> {
    return Quantity(this.double * that.double)
}

operator fun <X: Nat<*>, Power: S<X>, A: Measure> Quantity<Power, A>.div(that: Quantity<Power, A>): Quantity<X, A> {
    return Quantity(this.double / that.double)
}