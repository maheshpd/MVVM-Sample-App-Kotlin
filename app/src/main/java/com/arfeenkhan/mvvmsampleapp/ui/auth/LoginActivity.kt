package com.arfeenkhan.mvvmsampleapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arfeenkhan.mvvmsampleapp.R
import com.arfeenkhan.mvvmsampleapp.data.db.AppDatabase
import com.arfeenkhan.mvvmsampleapp.data.db.entities.User
import com.arfeenkhan.mvvmsampleapp.data.network.MyApi
import com.arfeenkhan.mvvmsampleapp.data.repositories.UserRepository
import com.arfeenkhan.mvvmsampleapp.databinding.ActivityLoginBinding
import com.arfeenkhan.mvvmsampleapp.ui.home.HomeActivity
import com.arfeenkhan.mvvmsampleapp.util.hide
import com.arfeenkhan.mvvmsampleapp.util.show
import com.arfeenkhan.mvvmsampleapp.util.snackbar
import com.arfeenkhan.mvvmsampleapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = MyApi()
        val db = AppDatabase(this)
        val repository = UserRepository(api,db)
        val factory = AuthViewModelFactory(repository)


        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {
                Intent(this,HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }


    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }


}
