package com.aplikasi.apptokosi02

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.apptokosi02.adapter.LaporanAdapter
import com.aplikasi.apptokosi02.adapter.ProdukAdapter
import com.aplikasi.apptokosi02.adapter.SupplierAdapter
import com.aplikasi.apptokosi02.api.BaseRetrofit
import com.aplikasi.apptokosi02.response.produk.ProdukResponse
import com.aplikasi.apptokosi02.response.supplier.SupplierResponse
import com.aplikasi.apptokosi02.response.transaksi.TransaksiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat
import java.util.*
import java.util.function.Supplier

class SupplierFragment : Fragment () {

    private val api by lazy { BaseRetrofit().endpoint }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_supplier, container, false)

        getSupplier(view)

        return view
    }

    fun getSupplier(view:View){
        val token = LoginActivity.sessionManager.getString("TOKEN")

        api.getSupplier(token.toString()).enqueue(object : Callback<SupplierResponse> {
            override fun onResponse(
                call: Call<SupplierResponse>,
                response: Response<SupplierResponse>
            ) {
               val rv = view.findViewById(R.id.rv_supplier) as RecyclerView

                rv.setHasFixedSize(true)
                rv.layoutManager = LinearLayoutManager(activity)
                val rvAdapter = SupplierAdapter(response.body()!!.data.supplier)
                rv.adapter = rvAdapter
            }

            override fun onFailure(call: Call<SupplierResponse>, t: Throwable) {
                Log.e("ProdukError",t.toString())
            }
        })

    }
}