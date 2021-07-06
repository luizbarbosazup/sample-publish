package br.com.itau.warriors.sample.core.service

import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.mockk
import java.util.*

@MicronautTest
class SaleServiceTest:AnnotationSpec() {

    private val infrastructureServicePort = mockk<InfrastructureServicePort>(relaxed = true)
    private val service = SaleServiceImpl(infrastructureServicePort)

    lateinit var sale:Sale

    @BeforeEach
    fun setUp(){
        sale = Sale(
            productid = UUID.fromString("95924b05-a2ff-4ec1-9d6a-aee540bc89ff"),
            qty = 10.0
        )
    }

    @Test
    fun `sending a sale e shoul be receive a void`(){
        val result = service.saveSale(sale = sale)
        result shouldBe Unit
    }





}