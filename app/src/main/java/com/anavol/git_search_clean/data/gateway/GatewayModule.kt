package com.anavol.git_search_clean.data.gateway

import org.koin.dsl.module

object GatewayModule {

    fun create() = module {
        single { GitSearchGateway(get()) }
    }
}