package br.com.itau.warriors.sample.core.port

import br.com.itau.warriors.sample.core.model.SaleInformation
import javax.inject.Singleton

@Singleton
interface EntrypointServicePort {
    fun saveSale(saleInformation: SaleInformation)
}