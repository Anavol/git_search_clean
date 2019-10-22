package com.anavol.git_search_clean.data.domain.git_user_search

import com.anavol.git_search_clean.data.domain.entity.GitUserEntity
import com.anavol.git_search_clean.data.gateway.GitSearchGateway
import io.reactivex.Single

class GitUserSearchInteractor(
    private val gitSearchGateway: GitSearchGateway
) {
    fun execute(login: String): Single<List<GitUserEntity>> = gitSearchGateway.search(login)
}