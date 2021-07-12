package br.com.itau.warriors.sample.core.service

import br.com.itau.warriors.sample.core.mapper.Convert
import br.com.itau.warriors.sample.core.model.SaleInformation
import br.com.itau.warriors.sample.core.port.EntrypointServicePort
import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.infrastructure.model.EventEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class SaleServiceImpl(val infrastructureService: InfrastructureServicePort):EntrypointServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun saveSale(saleInformation: SaleInformation) {
        logger.info("\ncore/service/save : ${saleInformation}")
        infrastructureService.saveSale(
            Convert.saleInformationToSaleEntityInformation(
                saleInformation = saleInformation))
    }

    override fun deleteSale(saleId: UUID) {
        logger.info("\ncore/service/delete : sale com id ${saleId}")

        infrastructureService.deleteSale(saleId = saleId)
    }



}