package br.com.itau.warriors.sample.core.service

import br.com.itau.warriors.sample.core.mapper.Convert
import br.com.itau.warriors.sample.core.model.SaleInformation
import br.com.itau.warriors.sample.core.port.EntrypointServicePort
import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.infrastructure.model.Event
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SaleServiceImpl(val infrastructureService: InfrastructureServicePort):EntrypointServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun saveSale(saleInformation: SaleInformation) {
        logger.info("\ncore/service/ : ${saleInformation}")
        infrastructureService.sendSale(
            Convert.saleInformationToSaleEntityInformation(
                saleInformation = saleInformation,
                event = Event.SAVE_SALE))
    }

}