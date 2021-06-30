package br.com.itau.warriors.sample.core.service

import br.com.itau.warriors.sample.core.port.InfrastructureServicePort
import io.kotest.core.spec.style.AnnotationSpec
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.mockk

@MicronautTest
class SaleServiceTest:AnnotationSpec() {

    val infraServicePort = mockk<InfrastructureServicePort>(relaxed = true)
    val service = SaleServiceImpl(infraServicePort)

z''


}