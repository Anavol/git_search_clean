package com.anavol.git_search_clean.ui.main

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.anavol.git_search_clean.R
import kotlinx.android.synthetic.main.content_main.view.*
import me.dmdev.rxpm.base.PmActivity
import me.dmdev.rxpm.base.PmController
import me.dmdev.rxpm.bindTo
import org.koin.core.context.GlobalContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

class MainActivity : PmActivity<MainActivityPM>() {



    private val gitUsersAdapter by lazy {
        GitUserRecyclerAdapter()
    }

    override fun providePresentationModel() = get<MainActivityPM>()

    override fun onBindPresentationModel(pm: MainActivityPM) {
        val layout = LayoutInflater.from(this.baseContext).inflate(R.layout.content_main,null,  false)
        layout.recyclerView.apply {
            adapter = gitUsersAdapter
            layoutManager = LinearLayoutManager(context)
        }

        pm.searchQuery bindTo gitUsersAdapter.submitList()

    }



    inline fun <reified T : Any> get(
        qualifier: Qualifier? = null,
        noinline parameters: ParametersDefinition? = null
    ): T = GlobalContext.get().koin.get(qualifier, parameters)
}
