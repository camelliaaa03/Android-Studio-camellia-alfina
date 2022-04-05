package id.camelliaalfina.wisatajogja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignIn: Button = findViewById(R.id.btn_signIn)
        btnSignIn.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_signIn -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}