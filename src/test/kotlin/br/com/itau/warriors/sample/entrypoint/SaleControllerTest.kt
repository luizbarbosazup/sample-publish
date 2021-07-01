package br.com.itau.warriors.sample.entrypoint

import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.port.EntrypointServicePort
import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import br.com.itau.warriors.sample.core.service.SaleServiceImpl
import br.com.itau.warriors.sample.entrypoint.controller.SaleController
import br.com.itau.warriors.sample.entrypoint.controller.dto.SaleRequestDto
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class SaleControllerTest:AnnotationSpec() {

    private val entrypointServicePort = mockk<EntrypointServicePort>(relaxed = true)
    private val infrastructureServicePort = mockk<InfrastructureServicePort>(relaxed = true)
    private val serviceImpl = SaleServiceImpl(infrastructureServicePort)

    val saleController = SaleController(entrypointServicePort)

    lateinit var saleRequestDto: SaleRequestDto
    lateinit var sale:Sale

    @BeforeEach
    fun setUp(){

        saleRequestDto = SaleRequestDto(
            productid = UUID.fromString("95924b05-a2ff-4ec1-9d6a-aee540bc89ff"),
            qty = 10.0
        )

        sale = Sale(
            productid = UUID.fromString("95924b05-a2ff-4ec1-9d6a-aee540bc89ff"),
            qty = 10.0
        )

    }

    @Test
    fun `sending a saleRequest and should be receive a sale`(){
        every { serviceImpl.saveSale(sale = sale) } answers { sale }

        val result = saleController.saveSale(saleRequestDto = saleRequestDto)
        result shouldBe Unit

    }

}