package com.arfeenkhan.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arfeenkhan.mvvmsampleapp.R
import com.arfeenkhan.mvvmsampleapp.data.db.entities.User
import com.arfeenkhan.mvvmsampleapp.databinding.ActivityLoginBinding
import com.arfeenkhan.mvvmsampleapp.util.hide
import com.arfeenkhan.mvvmsampleapp.util.show
import com.arfeenkhan.mvvmsampleapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }


    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        toast("${user.name} is Logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }


}
