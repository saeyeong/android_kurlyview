package com.example.kurlyview.domain

interface Review {
    val id: Int
    val title: String
    val description: String
    val createdAt: String
    val writer: String
}