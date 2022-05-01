package com.mercadolivro.mercadolivro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.mercadolivro.controller"])
class MercadoLivroApplication

fun main(args: Array<String>) {
	println("Iniciando a aplicação")
	runApplication<MercadoLivroApplication>(*args)
}
