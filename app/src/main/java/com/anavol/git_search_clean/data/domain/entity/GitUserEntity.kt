package com.anavol.git_search_clean.data.domain.entity

data class GitUserEntity (
    val login: String,
    val id: Long,
    val url: String,
    val type: String,
    val score: Float
)