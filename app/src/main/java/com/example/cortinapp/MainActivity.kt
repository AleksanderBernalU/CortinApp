package com.example.cortinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLogin(view: View){
        // Guardar datos
        db.collection("users").document("doe@mmail.com").set(
            hashMapOf("provider" to "provider",
                "address" to "Bogota DC",
            )
        )
        db.collection("users").document("doe@mmail.com").get().addOnSuccessListener {
            var addres = it.get("address") as String?
        }
        val intento = Intent(this,DrawerActivity::class.java)
        startActivity(intento)
    }
}