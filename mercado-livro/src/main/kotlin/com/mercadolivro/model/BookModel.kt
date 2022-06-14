package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import java.security.InvalidParameterException
import javax.persistence.*

@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
    ) {

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        var status: BookStatus? = null
        set (value) {
            if (field == BookStatus.CANCELADO || field == BookStatus.DELETADO) {
                throw InvalidParameterException("Não é possível alterar um livro com status ${field}")
            }
            field = value
        }

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?
    ): this(
        id, name, price, customer
    ) {
        this.status = status
    }
}