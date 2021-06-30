package br.com.itau.warriors.sample.infrastructure.model

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class SaleEvent (
    val id:UUID?,
    val productid:UUID,
    val qty:Double
        )