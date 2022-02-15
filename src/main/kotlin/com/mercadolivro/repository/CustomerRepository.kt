package com.mercadolivro.repository

import com.mercadolivro.model.CustomerModel
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CustomerRepository : JpaRepository<CustomerModel, Int> {
    fun findByName(name: String): CustomerModel
}
