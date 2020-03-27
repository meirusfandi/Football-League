package id.fanslab.footballleague.ui

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import id.fanslab.footballleague.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

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
                    typeface.isBold
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