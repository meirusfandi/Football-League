package id.fanslab.footballleague.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.fanslab.footballleague.R
import id.fanslab.footballleague.core.models.LeagueModel
import org.jetbrains.anko.*
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
}
