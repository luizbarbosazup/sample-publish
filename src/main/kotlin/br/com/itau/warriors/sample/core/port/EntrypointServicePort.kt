package br.com.itau.warriors.sample.core.port

import br.com.itau.warriors.sample.core.model.Sale
import javax.inject.Singleton

@Singleton
interface EntrypointServicePort {
    fun saveSale(sale:Sale)
}