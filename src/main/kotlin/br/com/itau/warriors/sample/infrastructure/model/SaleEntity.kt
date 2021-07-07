package br.com.itau.warriors.sample.infrastructure.model

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class SaleEntity (
    val productid:UUID,
    val qty:Double
        )