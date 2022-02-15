package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.extension.toCustomerModelWithId
import com.mercadolivro.extension.toCustomerModelWithoutId
import com.mercadolivro.service.CustomerService
import io.micronaut.http.annotation.*

@Controller("/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @Post("/")
    fun postCustomer(@Body customer: PostCustomerRequest) =
        customerService.createCustomer(customer.toCustomerModelWithoutId())

    @Get("/")
    fun getCustomer(@QueryValue name: String) = customerService.getCustomer(name)

    @Get("/{id}")
    fun getCustomerById(@QueryValue id: Int) = customerService.getCutomerById(id)

    @Put("/{id}")
    fun putCustomer(@Body customer: PostCustomerRequest, @QueryValue id: Int) =
        customerService.updateCustomer(customer.toCustomerModelWithId(id))

    @Delete("/{id}")
    fun deleteCustomer(@QueryValue id: Int) = customerService.deleteCustomer(id)
}
