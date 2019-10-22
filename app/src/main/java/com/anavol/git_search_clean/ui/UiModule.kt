package com.anavol.git_search_clean.ui

import com.anavol.git_search_clean.ui.main.MainActivityPM
import org.koin.dsl.module

object UiModule {
    fun create() = module {
        factory { MainActivityPM(get()) }
    }
}