package br.com.itau.warriors.sample.core.model

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class Sale(
    val productid:UUID,
    val qty:Double
)