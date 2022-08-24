package com.example.kurlyview.domain

interface Review {
    val id: Int
    val title: String
    val body: String
    val createDt: String
    val writer: String
}