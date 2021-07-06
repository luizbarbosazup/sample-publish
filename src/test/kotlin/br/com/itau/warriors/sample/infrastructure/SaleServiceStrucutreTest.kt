package br.com.itau.warriors.sample.infrastructure

import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.infrastructure.broker.nats.SaleClient
import br.com.itau.warriors.sample.infrastructure.model.SaleEvent
import br.com.itau.warriors.sample.infrastructure.service.SaleService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

class SaleServiceStrucutreTest:AnnotationSpec() {

    private val saleCliente = mockk<SaleClient>(relaxed = true)
    private val infrastructureServicePort = mockk<InfrastructureServicePort>(relaxed = true)
    private val saleService = SaleService(saleClient = saleCliente)

    lateinit var saleEvent: SaleEvent

    val uuid = UUID.randomUUID()

    @BeforeEach
    fun setUp(){
        saleEvent = SaleEvent(uuid,10.0)
    }

    @Test
    fun `should be send a message to nats`(){
        every { infrastructureServicePort.sendSale(saleEvent = saleEvent) } answers {Unit}
        val result = saleService.sendSale(saleEvent = saleEvent)
        result shouldBe Unit
    }

}