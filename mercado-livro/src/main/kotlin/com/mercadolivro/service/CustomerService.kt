package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(name)
        }
        return customerRepository.findAll().toList()
    }

    fun get(id: Int): CustomerModel {
       return customerRepository.findById(id).get()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
throw RuntimeException()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw RuntimeException()
        }
        customerRepository.deleteById(id)
    }

}