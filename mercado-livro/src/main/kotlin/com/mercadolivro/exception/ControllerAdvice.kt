package com.mercadolivro.exception

import com.mercadolivro.controller.response.ErrorResponse
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ControllerAdvice: ResponseEntityExceptionHandler()  {

    @ExceptionHandler(value = [(BookNotFoundException::class)])
    fun handleBookNotFoundException(ex: BookNotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
         val erro = ErrorResponse(
            400,
            "Este recurso não existe!",
            "0001",
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

}