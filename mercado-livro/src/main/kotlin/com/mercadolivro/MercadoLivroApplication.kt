package com.mercadolivro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = ["com.mercadolivro.config",
        "com.mercadolivro.controller",
        "com.mercadolivro.enums",
        "com.mercadolivro.exception",
        "com.mercadolivro.extension",
        "com.mercadolivro.model",
        "com.mercadolivro.repository",
        "com.mercadolivro.service",
        "com.mercadolivro.validation"]
)
class MercadoLivroApplication

fun main(args: Array<String>) {
    println("Iniciando a aplicação")
    runApplication<MercadoLivroApplication>(*args)
}
