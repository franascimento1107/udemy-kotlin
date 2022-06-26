package com.mercadolivro.exception

import com.mercadolivro.controller.response.ErrorResponse
import com.mercadolivro.controller.response.FieldErrorResponse
import com.mercadolivro.enums.Errors
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ControllerAdvice: ResponseEntityExceptionHandler()  {

    @ExceptionHandler(value = [(NotFoundException::class)])
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
         val erro = ErrorResponse(
             HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(value = [(BadRequestException::class)])
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [(AlreadyExistsException::class)])
    fun handleAlreadyExistsException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }
    
    protected override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status : HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.ML001.message,
            Errors.ML001.code,
            ex.bindingResult.fieldErrors.map { FieldErrorResponse(it.defaultMessage ?: "invalid!", it.field) }
        )
        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }

}