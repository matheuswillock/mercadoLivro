package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import jakarta.inject.Singleton

@Singleton
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    fun createCustomer(customer: CustomerModel): Any =
        try {
            HttpResponse.created(customerRepository.save(customer))
        } catch (ex: Exception) {
            HttpResponse.status(HttpStatus.NOT_ACCEPTABLE, "E-mail already registered")
        }

    fun getCustomer(name: String?): Any = try {
        HttpResponse.ok(
            name?.let {
                customerRepository.findByName(it)
            }
        )
    } catch (ex: Exception) {
        HttpResponse.ok(customerRepository.findAll())
    }

    fun getCutomerById(id: Int): Any = when (customerRepository.existsById(id)) {
        false -> {
            HttpResponse.notFound()
        }
        else -> {
            HttpResponse.ok(customerRepository.findById(id))
        }
    }

    fun updateCustomer(customer: CustomerModel) = try {
        HttpResponse.ok(customerRepository.update(customer))
    } catch (ex: Exception) {
        HttpResponse.notFound()
    }!!

    fun deleteCustomer(id: Int) = when (customerRepository.existsById(id)) {
        true -> {
            customerRepository.deleteById(id)
            HttpStatus.NO_CONTENT
        }
        else -> HttpStatus.NOT_FOUND
    }
}
