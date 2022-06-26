package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.controller.response.CustomerResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import com.mercadolivro.service.CustomerService
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.extension.toResponse
import javax.validation.Valid

@RestController
@RequestMapping("customers")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.findAll(name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): CustomerResponse {
        return customerService.getById(id.toInt()).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody @Valid customer: PutCustomerRequest) {
        val customerSaved = customerService.getById(id.toInt())
        customerService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id.toInt())
    }

}