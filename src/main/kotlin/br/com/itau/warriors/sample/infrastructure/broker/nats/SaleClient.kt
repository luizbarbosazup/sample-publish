package br.com.itau.warriors.sample.infrastructure.broker.nats

import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface SaleClient {

    @Subject("chanel.product.sale")
    fun sendSale(saleEntityInformation: SaleEntityInformation)

}