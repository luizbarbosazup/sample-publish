package br.com.itau.warriors.sample.infrastructure.service

import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.infrastructure.broker.nats.SaleClient
import br.com.itau.warriors.sample.infrastructure.model.EventEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class SaleService(val saleClient: SaleClient):InfrastructureServicePort {


    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun saveSale(saleEntityInformation: SaleEntityInformation) {
        logger.info("\ninfrastructure/service [ save ] : ${saleEntityInformation}")
        saleClient.sendSale(saleEntityInformation = saleEntityInformation)
    }

    override fun deleteSale(saleId: UUID) {
        logger.info("\ninfrastructura/service [ delete ] : ${saleId}")
        saleClient.sendSale(
            saleEntityInformation = SaleEntityInformation(
                eventEntity = EventEntity.DELETE_SALE,
                saleEntity = SaleEntity(
                    saleId = saleId,
                    productid = UUID.randomUUID(),
                    qty = 0.0
                )
            ) )
    }




}