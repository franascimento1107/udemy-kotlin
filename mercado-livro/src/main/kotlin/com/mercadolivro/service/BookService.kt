package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO).toList()
    }

    fun getById(id: Int): BookModel {
        return bookRepository.findById(id).get()
    }

    fun delete(id: Int) {
        val book = bookRepository.findById(id).get()

        book.status = BookStatus.CANCELADO

        this.update(book)
    }

    fun update(book: BookModel) {
        if (!bookRepository.existsById(book.id!!)) {
            throw RuntimeException()
        }
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        var books = bookRepository.findByCustomer(customer)

        for (book in books) {
            book.status = BookStatus.CANCELADO
        }

        bookRepository.saveAll(books)
    }

}
