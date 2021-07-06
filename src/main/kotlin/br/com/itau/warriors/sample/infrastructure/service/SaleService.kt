package br.com.itau.warriors.sample.infrastructure.service

import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.infrastructure.broker.nats.SaleClient
import br.com.itau.warriors.sample.infrastructure.model.SaleEvent
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SaleService(val saleClient: SaleClient):InfrastructureServicePort {


    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun sendSale(saleEvent: SaleEvent) {

        logger.info("\ninfrastructure/service : ${saleEvent}")

        saleClient.sendSale(saleEvent = saleEvent)

        logger.info("\ninfrastructure/service : ${saleEvent} ... ENVIADO")
    }
}