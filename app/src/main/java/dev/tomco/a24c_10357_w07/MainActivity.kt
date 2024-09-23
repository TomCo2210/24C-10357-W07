package dev.tomco.a24c_10357_w07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dev.tomco.a24c_10357_w07.databinding.ActivityMainBinding
import dev.tomco.a24c_10357_w07.utilities.DataManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database :FirebaseDatabase
    private lateinit var messageRef : DatabaseReference
    private lateinit var moviesRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageRef = initDBConnection("message")
        moviesRef = initDBConnection("movies")

        initViews()

        //update single value:
        updateMovieRating(1,7.99999F)



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




        // Read from the database
//        myRef.addListenerForSingleValueEvent(object : ValueEventListener { // For one time data fetching from DB
        messageRef.addValueEventListener(object : ValueEventListener { // For realtime data fetching from DB
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value
                Log.d("Data", "Value is: $value")
                binding.mainLBLGreeting.text = buildString {
                    append(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Data Error", "Failed to read value.", error.toException())
            }
        })
    }

    private fun initDBConnection(path: String) :DatabaseReference{
        database = Firebase.database
        return database.getReference(path)
    }

    private fun initViews() {
        binding.mainBTNSend.setOnClickListener(
            View.OnClickListener {
                // Write a message to the database
                messageRef.setValue(binding.mainETMessage.text.toString())
            }
        )
    }

    private fun returnToLoginActivity()  {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun updateMovieRating(number: Int, rating: Float){
        moviesRef // in movies[]
            .child("$number") // movies[number]
            .child("rating") // movies[number][rating]
            .setValue(rating)
    }
}