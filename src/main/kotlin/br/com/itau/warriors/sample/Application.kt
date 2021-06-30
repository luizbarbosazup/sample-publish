package br.com.itau.warriors.sample

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.itau.warriors.sample")
		.start()
}

