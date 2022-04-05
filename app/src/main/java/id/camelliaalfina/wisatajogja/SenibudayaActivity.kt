package id.camelliaalfina.wisatajogja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SenibudayaActivity : AppCompatActivity() {
    private lateinit var rvSeni: RecyclerView
    private var list: ArrayList<Seni> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_senibudaya)
        setActionBarTitle(title)

        rvSeni = findViewById(R.id.rv_seni)
        rvSeni.setHasFixedSize(true)

        list.addAll(SeniData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvSeni.layoutManager = LinearLayoutManager(this)
        val listSeniAdapter = ListSeniAdapter(list)
        rvSeni.adapter = listSeniAdapter

        listSeniAdapter.setOnItemClickCallback(object : ListSeniAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Seni) {
                showSelectedSeni(data)
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun showRecyclerGrid() {
        rvSeni.layoutManager = GridLayoutManager(this, 2)
        val gridSeniAdapter = GridSeniAdapter(list)
        rvSeni.adapter = gridSeniAdapter

        gridSeniAdapter.setOnItemClickCallback(object : GridSeniAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Seni) {
                showSelectedSeni(data)
            }
        })

    }
    private fun showRecyclerCardView() {
        rvSeni.layoutManager = LinearLayoutManager(this)
        val cardViewSeniAdapter = CardViewSeniAdapter(list)
        rvSeni.adapter = cardViewSeniAdapter
    }
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }

            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }
    private fun showSelectedSeni(seni: Seni) {
        Toast.makeText(this, "Kamu memilih " + seni.name, Toast.LENGTH_SHORT).show()
    }
}