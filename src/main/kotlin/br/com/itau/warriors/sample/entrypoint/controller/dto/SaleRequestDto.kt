package br.com.itau.warriors.sample.entrypoint.controller.dto

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class SaleRequestDto (
    val productid:UUID,
    val qty:Double
        )