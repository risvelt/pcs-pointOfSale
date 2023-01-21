package com.aplikasi.apptokosi02.api
import com.aplikasi.apptokosi02.response.itemTransaksi.ItemTransaksiResponsePost
import com.aplikasi.apptokosi02.response.login.LoginResponse
import com.aplikasi.apptokosi02.response.produk.ProdukResponse
import com.aplikasi.apptokosi02.response.produk.ProdukResponsePost
import com.aplikasi.apptokosi02.response.supplier.Supplier
import com.aplikasi.apptokosi02.response.supplier.SupplierResponse
import com.aplikasi.apptokosi02.response.transaksi.TransaksiResponse
import com.aplikasi.apptokosi02.response.transaksi.TransaksiResponsePost

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiEndpoint {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Call<LoginResponse>


    @GET("produk")
    fun getProduk(
        @Header("Authorization") token : String
    ) : Call<ProdukResponse>

    @FormUrlEncoded
    @POST("produk")
    fun postproduk(
        @Header("Authorization") token: String,
        @Field("admin_id") admin_id:Int,
        @Field("nama") nama:String,
        @Field("harga") harga: Int,
        @Field("stok") stok: Int
    ) : Call<ProdukResponsePost>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "produk", hasBody = true)
    fun deleteproduk(
        @Header("Authorization") token: String,
        @Field("id") id:Int,
    ) : Call<ProdukResponsePost>

    @FormUrlEncoded
    @HTTP(method = "PUT", path = "produk", hasBody = true)
    fun putproduk(
        @Header("Authorization") token: String,
        @Field("id") id:Int,
        @Field("admin_id") admin_id:Int,
        @Field("nama") nama:String,
        @Field("harga") harga:Int,
        @Field("stok") stok:Int,
    ) : Call<ProdukResponsePost>

    @FormUrlEncoded
    @POST("transaksi")
    fun postTransaksi(
        @Header("Authorization") token: String,
        @Field("admin_id") admin_id:Int,
        @Field("total") total: Int
    ) : Call<TransaksiResponsePost>

    @FormUrlEncoded
    @POST("item_transaksi")
    fun postItemTransaksi(
        @Header("Authorization") token: String,
        @Field("transaksi_id") transaksi_id:Int,
        @Field("produk_id") produk_id: Int,
        @Field("qty") qty: Int,
        @Field("harga_saat_transaksi") harga_saat_transaksi: Int
    ) : Call<ItemTransaksiResponsePost>

    @GET("transaksi")
    fun getTransaksi(
        @Header("Authorization") token : String
    ) : Call<TransaksiResponse>

    @GET("supplier")
    fun getSupplier(
        @Header("Authorization") token : String
    ) : Call<SupplierResponse>

}

