package br.com.itau.warriors.sample.infrastructure.service

import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.infrastructure.broker.nats.SaleClient
import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SaleService(val saleClient: SaleClient):InfrastructureServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun sendSale(saleEntityInformation: SaleEntityInformation) {

        logger.info("\ninfrastructure/service : ${saleEntityInformation}")

        saleClient.sendSale(saleEntityInformation = saleEntityInformation)

    }
}