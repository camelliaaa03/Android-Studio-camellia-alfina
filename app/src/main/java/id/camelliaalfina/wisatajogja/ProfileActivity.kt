package id.camelliaalfina.wisatajogja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnProfile: MaterialButton = findViewById(R.id.todoB)
        btnProfile.setOnClickListener(this)

        val btncardSeni: CardView = findViewById(R.id.cardSeni)
        btncardSeni.setOnClickListener(this)

        val btncardNews: CardView = findViewById(R.id.cardNews)
        btncardNews.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.todoB -> {
                val moveIntent = Intent(this@ProfileActivity, UserProfileActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.cardSeni -> {
                val moveIntent = Intent(this@ProfileActivity, SenibudayaActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.cardNews -> {
                val moveIntent = Intent(this@ProfileActivity, detailNewsActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}