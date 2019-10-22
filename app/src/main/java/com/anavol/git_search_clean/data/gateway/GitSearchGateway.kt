package com.anavol.git_search_clean.data.gateway

import com.anavol.git_search_clean.data.domain.entity.GitUserEntity
import com.anavol.git_search_clean.data.dto.GitUser
import com.anavol.git_search_clean.data.network.GitApiClient
import io.reactivex.Single

class GitSearchGateway (
    private val gitApiClient: GitApiClient
){
    fun search(login: String): Single<List<GitUserEntity>> = gitApiClient.searchUsers(login).map {
        it.map { gitUser -> gitUser.toGitUserEntity() }
    }

    private fun GitUser.toGitUserEntity():GitUserEntity = GitUserEntity(login, id, url, type, score)
}