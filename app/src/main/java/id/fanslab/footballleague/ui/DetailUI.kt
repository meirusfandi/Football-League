package id.fanslab.footballleague.ui

import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import id.fanslab.footballleague.core.models.LeagueModel
import org.jetbrains.anko.*

class  DetailUI(private val leagueModel: LeagueModel?): AnkoComponent<DetailActivity> {
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

                // league name section
                textView {
                    text = leagueModel?.leagueName
                    textSize = sp(12).toFloat()
                    padding = dip(8)
                    typeface.isBold
                }

                // league detail section
                textView {
                    text = leagueModel?.leagueDetail
                    textSize = sp(10).toFloat()
                    padding = dip(8)
                }
            }
        }
    }
}