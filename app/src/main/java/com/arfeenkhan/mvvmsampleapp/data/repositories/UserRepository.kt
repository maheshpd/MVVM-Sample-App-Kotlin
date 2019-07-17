package com.arfeenkhan.mvvmsampleapp.data.repositories

import com.arfeenkhan.mvvmsampleapp.data.network.MyApi
import com.arfeenkhan.mvvmsampleapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {
     suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return MyApi().userLogin(email,password)
    }
}