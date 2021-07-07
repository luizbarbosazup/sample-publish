package br.com.itau.warriors.sample.core.port

import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation

interface InfrastructureServicePort {

    fun sendSale(saleEntityInformation: SaleEntityInformation)

}