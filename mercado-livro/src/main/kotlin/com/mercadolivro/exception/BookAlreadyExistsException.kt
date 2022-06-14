package com.mercadolivro.exception

class BookAlreadyExistsException (override val message: String?) : Exception(message) {
}