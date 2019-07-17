package com.arfeenkhan.mvvmsampleapp.data.network.responses

import com.arfeenkhan.mvvmsampleapp.data.db.entities.User

data class AuthResponse(
    val isSuccessfull: Boolean?,
    val message: String?,
    val user: User?
)