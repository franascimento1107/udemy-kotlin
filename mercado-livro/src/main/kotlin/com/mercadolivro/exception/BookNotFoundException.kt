package com.mercadolivro.exception

class BookNotFoundException(override val message: String?) : Exception(message) {
}