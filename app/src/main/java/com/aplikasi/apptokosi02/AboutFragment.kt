package com.aplikasi.apptokosi02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val btnlogout = view.findViewById<Button>(R.id.btnLogout)
        btnlogout.setOnClickListener{
            LoginActivity.sessionManager.clearSession()

            val moveIntent = Intent(activity,LoginActivity::class.java)
            startActivity(moveIntent)
            activity?.finish()
        }

        return view
    }


}