package io.inklot.muskt

interface Nat<A>
typealias Zero = Nat<Nothing>
interface S<A: Nat<*>>: Nat<S<A>>

typealias One = S<Zero>
typealias Two = S<One>
typealias Three = S<Two>