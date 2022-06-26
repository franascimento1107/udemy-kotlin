package com.mercadolivro.exception

class AlreadyExistsException (override val message: String, val errorCode: String) : Exception(message) {
}