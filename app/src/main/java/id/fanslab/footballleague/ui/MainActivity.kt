package id.fanslab.footballleague.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import id.fanslab.footballleague.R
import id.fanslab.footballleague.core.adapter.LeagueAdapter
import id.fanslab.footballleague.core.models.LeagueModel
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var leagueModel : MutableList<LeagueModel> = mutableListOf()

    private fun initData() {
        val id = resources.getStringArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val poster = resources.obtainTypedArray(R.array.league_poster)
        val detail = resources.getStringArray(R.array.league_detail)

        leagueModel.clear()

        for (index in id.indices) {
            leagueModel.add(LeagueModel(id[index], name[index], poster.getResourceId(index, 0), detail[index]))
        }

        poster.recycle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        MainActivityUI(leagueModel).setContentView(this)
    }

    inner class MainActivityUI(private val leagueModels: MutableList<LeagueModel>): AnkoComponent<MainActivity> {
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
                    adapter = LeagueAdapter(leagueModels) {
                        startActivity<DetailActivity>(DetailActivity.LEAGUE_ITEM to it)
                    }
                }
            }
        }
    }

    class ListUI: AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            cardView {
                lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(8)
                }
                padding = dip(8)
                radius = dip(8).toFloat()

                linearLayout {
                    orientation = LinearLayout.VERTICAL

                    // image poster section
                    imageView {
                        id = R.id.league_poster
                        imageResource = R.drawable.premier_league
                    }.lparams(height = 200){
                        margin = dip(8)
                    }

                    // text league name section
                    textView {
                        id = R.id.league_name
                        text = context.getString(R.string.english_premier_league)
                        textSize = sp(12).toFloat()
                        maxLines = 2
                        padding = dip(8)
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        height = wrapContent,
                        width = matchParent
                    ){
                        margin = dip(8)
                    }
                }
            }
        }
    }
}
