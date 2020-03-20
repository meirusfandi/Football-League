package id.fanslab.footballleague.core.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueModel(val leagueId: String?, val leagueName: String?, val leaguePoster: Int?, val leagueDetail: String?): Parcelable