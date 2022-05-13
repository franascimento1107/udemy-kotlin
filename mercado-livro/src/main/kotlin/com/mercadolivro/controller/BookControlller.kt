package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.model.BookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookControlller(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> = bookService.findAll()

    @GetMapping("/active")
    fun findActives(): List<BookModel> = bookService.findActives()

    @GetMapping("/{id}")
    fun getById(id: Int): BookModel {
        return bookService.getById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        bookService.delete(id.toInt())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.getById(id.toInt())
        bookService.update(book.toBookModel(bookSaved))
    }
}