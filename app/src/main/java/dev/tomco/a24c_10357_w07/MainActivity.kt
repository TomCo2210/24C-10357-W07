package dev.tomco.a24c_10357_w07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dev.tomco.a24c_10357_w07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            Log.d("UID:", "onCreate: " + user?.uid)
            binding.mainLBLGreeting.text = buildString {
                append("Hello ")
                append(user?.uid)
            }
            binding.mainBTNSignout.setOnClickListener(
                View.OnClickListener { AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener {
                        returnToLoginActivity()
                    } }
            )
        }
    }

    private fun returnToLoginActivity()  {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}