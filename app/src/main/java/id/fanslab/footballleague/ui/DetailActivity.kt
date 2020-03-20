package id.fanslab.footballleague.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import id.fanslab.footballleague.core.models.LeagueModel
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val LEAGUE_ITEM = "league_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val leagueModel = intent.getParcelableExtra<LeagueModel>(LEAGUE_ITEM)
        DetailActivityUI(leagueModel).setContentView(this)
    }

    inner class  DetailActivityUI(private val leagueModel: LeagueModel?): AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            scrollView {
                lparams(
                    width = matchParent,
                    height = matchParent
                )
                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    lparams(
                        height = wrapContent,
                        width = matchParent
                    )
                    // poster section
                    imageView {
                        leagueModel?.leaguePoster?.let { Picasso.get().load(it).into(this) }
                    }.lparams(
                        height = 200,
                        width = matchParent
                    )

                    // id section
                    textView {
                        text = leagueModel?.leagueId
                        textSize = sp(10).toFloat()
                        padding = dip(8)
                    }

                    // league name section
                    textView {
                        text = leagueModel?.leagueName
                        textSize = sp(16).toFloat()
                        padding = dip(8)
                    }

                    // league detail section
                    textView {
                        text = leagueModel?.leagueDetail
                        textSize = sp(12).toFloat()
                        padding = dip(8)
                    }
                }
            }
        }
    }
}
