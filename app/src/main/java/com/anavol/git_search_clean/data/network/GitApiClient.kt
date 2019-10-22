package com.anavol.git_search_clean.data.network

import com.anavol.git_search_clean.data.dto.GitUser
import io.reactivex.Single

class GitApiClient(private val apiService: GithubApiService) {

    fun searchUsers(login: String, perPage: Int = 30, page: Int = 1): Single<List<GitUser>> {
        return apiService.search(login, perPage, page)
            .map { it.items.map { gitUser -> gitUser.toGitUserDto() } }
    }

    private fun com.anavol.git_search_clean.data.network.GitUser.toGitUserDto(): GitUser {
        return GitUser(login,id, url, type, score)
    }
}