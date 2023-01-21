package com.aplikasi.apptokosi02.response.supplier


data class SupplierResponsePost (
    val `data` : DataSupplier,
    val message : String,
    val success : Boolean
)

data class DataSupplier (
    val `supplier` : Supplier
)