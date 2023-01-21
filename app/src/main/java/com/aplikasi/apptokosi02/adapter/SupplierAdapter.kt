package com.aplikasi.apptokosi02.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.apptokosi02.R
import com.aplikasi.apptokosi02.response.supplier.Supplier

class SupplierAdapter(val listSupplier: List<Supplier>):RecyclerView.Adapter<SupplierAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_supplier, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val supplier = listSupplier[position]
        holder.txtNoSupplier.text = supplier.id_supplier
        holder.txtNamaSupplier.text = supplier.namasupplier
    }

    override fun getItemCount(): Int {
        return listSupplier.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNoSupplier = itemView.findViewById(R.id.txtNoSupplier) as TextView
        val txtNamaSupplier = itemView.findViewById(R.id.txtNamaSupplier) as TextView
    }
}