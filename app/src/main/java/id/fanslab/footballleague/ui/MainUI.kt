package id.fanslab.footballleague.ui

import androidx.recyclerview.widget.GridLayoutManager
import id.fanslab.footballleague.core.adapter.LeagueAdapter
import id.fanslab.footballleague.core.models.LeagueModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI(private val leagueModel: List<LeagueModel>): AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            lparams(
                width = matchParent,
                height = wrapContent
            )
            recyclerView {
                lparams(
                    width = matchParent,
                    height = wrapContent
                )
                layoutManager = GridLayoutManager(context, 2)
                adapter = LeagueAdapter(leagueModel) {
                    startActivity<DetailActivity>(DetailActivity.LEAGUE_ITEM to it)
                }
            }
        }
    }
}