package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModelWithoutId(): CustomerModel {
    return CustomerModel(id=null, name=this.name, email=this.email)
}

fun PostCustomerRequest.toCustomerModelWithId(id: Int): CustomerModel {
    return CustomerModel(id, this.name, this.email)
}