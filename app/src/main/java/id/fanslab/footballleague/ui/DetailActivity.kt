package id.fanslab.footballleague.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import id.fanslab.footballleague.core.models.LeagueModel
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val LEAGUE_ITEM = "league_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val leagueModel = intent.getParcelableExtra<LeagueModel>(LEAGUE_ITEM)

        DetailUI(leagueModel).setContentView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
