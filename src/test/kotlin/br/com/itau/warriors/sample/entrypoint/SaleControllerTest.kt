package br.com.itau.warriors.sample.entrypoint

import br.com.itau.warriors.sample.core.port.EntrypointServicePort
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

    private val saleService = mockk<EntrypointServicePort>(relaxed = true)
    private val controller = SaleController(saleService)

    lateinit var saleRequestDto: SaleRequestDto

    @BeforeEach
    fun setUp(){

        saleRequestDto = SaleRequestDto(
            productid = UUID.fromString("95924b05-a2ff-4ec1-9d6a-aee540bc89ff"),
            qty = 0.0)

    }

    @Test
    fun `sending a saleRequestDTO to core and should be receive a sale`(){
        every { saleService.saveSale(any()) } answers { Unit }
        val result = controller.saveSale(saleRequestDto = saleRequestDto)
        result shouldBe Unit
    }

    @Test
    fun `sending a saleId to delete and should be received Unit`(){
        every{ saleService.deleteSale(any())} answers { Unit }
        val result  = controller.deleteSale(UUID.fromString("95924b05-a2ff-4ec1-9d6a-aee540bc89ff"))
        result shouldBe Unit
    }

}