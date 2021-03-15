package com.ijniclohot.stockbitmobilechallenge.features.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.facebook.login.widget.LoginButton
import com.ijniclohot.stockbitmobilechallenge.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    fun setupView(){
        login_by_email_button.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_watchListFragment)
        }
    }



    private lateinit var navController : NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        facebook_sign_in_button.fragment = this
        navController = Navigation.findNavController(view)
        setupView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}