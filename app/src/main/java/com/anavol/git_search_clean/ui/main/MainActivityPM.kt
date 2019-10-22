package com.anavol.git_search_clean.ui.main

import com.anavol.git_search_clean.data.domain.entity.GitUserEntity
import com.anavol.git_search_clean.data.domain.git_user_search.GitUserSearchInteractor
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.state

class MainActivityPM (
    private val gitUserSearchInteractor: GitUserSearchInteractor
): PresentationModel() {

    val searchResults = state<List<GitUserEntity>>()

    val searchQuery = state<String>()

    override fun onBind() {
        super.onBind()
        searchQuery.observable.subscribe {
            gitUserSearchInteractor.execute(searchQuery.value)
                .subscribe(searchResults.consumer)
                .untilDestroy()

        }
            .untilDestroy()
    }

}