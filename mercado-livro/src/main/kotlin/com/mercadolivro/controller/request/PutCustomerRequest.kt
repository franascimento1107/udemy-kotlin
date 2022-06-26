package com.mercadolivro.controller.request

import com.mercadolivro.enums.CustomerStatus
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest (
    @field:NotEmpty(message = "Nome deve ser informado!")
    var name: String?,

    @field:Email(message = "O email deveser válido!")
    var email: String?,

    var status: CustomerStatus?
)