package br.com.itau.warriors.sample.core.port

import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation
import java.util.*

interface InfrastructureServicePort {

    fun saveSale(saleEntityInformation: SaleEntityInformation)
    fun deleteSale(saleId: UUID)

}