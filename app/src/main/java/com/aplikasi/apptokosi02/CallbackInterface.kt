package com.aplikasi.apptokosi02

import com.aplikasi.apptokosi02.response.cart.Cart

interface CallbackInterface {
    fun passResultCallback(total:String,cart:ArrayList<Cart>)
}