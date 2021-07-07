package br.com.itau.warriors.sample.core.mapper

import br.com.itau.warriors.sample.core.model.Event
import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.model.SaleInformation

import br.com.itau.warriors.sample.entrypoint.controller.dto.SaleRequestDto
import br.com.itau.warriors.sample.infrastructure.model.SaleEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleEntityInformation

class Convert {
    companion object{
        fun saleRequestDtoToSaleInformation(saleRequestDto: SaleRequestDto, event:Event) =
            SaleInformation(
                event = event,
                sale=Sale(
                    productid = saleRequestDto.productid,
                    qty = saleRequestDto.qty)
            )

        fun saleInformationToSaleEntityInformation(saleInformation: SaleInformation,event:br.com.itau.warriors.sample.infrastructure.model.Event) =
            SaleEntityInformation(
                event = event,
                SaleEntity(
                    productid = saleInformation.sale.productid,
                    qty = saleInformation.sale.qty))


    }
}