package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.exception.BookNotFoundException
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun getById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow { BookNotFoundException("Não existe este recurso!") }
    }

    fun delete(id: Int) {
        val book = getById(id)

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
