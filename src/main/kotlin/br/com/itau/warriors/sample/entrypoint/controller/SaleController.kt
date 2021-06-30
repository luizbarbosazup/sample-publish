package br.com.itau.warriors.sample.entrypoint.controller

import br.com.itau.warriors.sample.core.mapper.Convert
import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.port.EntrypointServicePort
import br.com.itau.warriors.sample.entrypoint.controller.dto.SaleRequestDto
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import org.slf4j.LoggerFactory

@Controller("/api/v1/sales")
class SaleController(val servicePort: EntrypointServicePort) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun saveSale(@Body saleRequestDto: SaleRequestDto){
        logger.info("\nValores Recebidos do Client : ${saleRequestDto}")
        servicePort.saveSale(Convert.saleRequestDtoToSale(saleRequestDto))
    }
}