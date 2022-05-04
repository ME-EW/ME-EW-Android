package com.example.domain.model

data class User(
    var userID: Int,
    var accessToken: String,
    var refreshToken: String,
    var nickName: String
)
