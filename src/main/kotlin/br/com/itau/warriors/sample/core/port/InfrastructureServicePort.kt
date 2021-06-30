package br.com.itau.warriors.sample.core.port

import br.com.itau.warriors.sample.infrastructure.model.SaleEvent

interface InfrastructureServicePort {

    fun sendSale(saleEvent: SaleEvent)

}