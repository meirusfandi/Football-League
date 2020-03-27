package id.fanslab.footballleague.core.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.fanslab.footballleague.R
import id.fanslab.footballleague.core.models.LeagueModel
import id.fanslab.footballleague.ui.ListUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private val leagueModels: List<LeagueModel>, private var listener: (LeagueModel) -> Unit):
    RecyclerView.Adapter<LeagueAdapter.LeagueHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueHolder(
        ListUI().createView(
            AnkoContext.create(parent.context, parent)
        )
    )

    override fun getItemCount(): Int = leagueModels.size

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bindItem(leagueModels[position], listener)
    }

    class LeagueHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
        private var name : TextView = containerView.findViewById(R.id.league_name)
        private var poster : ImageView = containerView.findViewById(R.id.league_poster)

        fun bindItem(leagueModel: LeagueModel, listener: (LeagueModel) -> Unit) {

            name.text = leagueModel.leagueName
            leagueModel.leaguePoster?.let { Picasso.get().load(it).into(poster) }

            containerView.setOnClickListener {
                listener(leagueModel)
            }

        }
    }
}