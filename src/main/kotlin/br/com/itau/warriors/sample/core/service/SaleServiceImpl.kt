package br.com.itau.warriors.sample.core.service

import br.com.itau.warriors.sample.core.mapper.Convert
import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.port.EntrypointServicePort
import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SaleServiceImpl(val infrastructureService: InfrastructureServicePort):EntrypointServicePort {
    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun saveSale(sale: Sale) {
        logger.info("\ncore/service/ : ${sale}")
        infrastructureService.sendSale(saleEvent = Convert.saleToSalveEvent(sale = sale))
    }
}