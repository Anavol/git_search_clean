package com.anavol.git_search_clean.data.domain

import com.anavol.git_search_clean.data.domain.git_user_search.GitUserSearchInteractor
import org.koin.dsl.module

object InteractorModule {

    fun create() = module {
        factory { GitUserSearchInteractor(get()) }
    }
}