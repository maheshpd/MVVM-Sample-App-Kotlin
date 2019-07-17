package com.arfeenkhan.mvvmsampleapp.data.repositories

import com.arfeenkhan.mvvmsampleapp.data.network.MyApi
import com.arfeenkhan.mvvmsampleapp.data.network.SafeApiRequest
import com.arfeenkhan.mvvmsampleapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest() {
     suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { MyApi().userLogin(email,password) }
    }
}