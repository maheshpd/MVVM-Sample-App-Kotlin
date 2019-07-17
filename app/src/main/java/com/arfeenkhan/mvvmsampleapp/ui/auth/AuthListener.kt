package com.arfeenkhan.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData
import com.arfeenkhan.mvvmsampleapp.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}