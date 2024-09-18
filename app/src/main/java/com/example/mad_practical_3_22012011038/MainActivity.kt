package com.example.mad_practical_3_22012011038

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val browsButton = findViewById<Button>(R.id.brows)
        val urlText = findViewById<EditText>(R.id.urltext)
        browsButton.setOnClickListener {
            val url = urlText.text.toString()
            if (url.isNotBlank()) {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(webIntent)
            } else {
                Toast.makeText(this, "Please enter a valid URL", Toast.LENGTH_SHORT).show()
            }
        }

        val callButton = findViewById<Button>(R.id.call)
        val phoneText = findViewById<EditText>(R.id.phonetext)
        callButton.setOnClickListener {
            val phoneNumber = phoneText.text.toString()
            if (phoneNumber.isNotBlank()) {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(callIntent)
            } else {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            }
        }

        val logButton = findViewById<Button>(R.id.log)
        logButton.setOnClickListener {
            val callLogUri = CallLog.Calls.CONTENT_URI
            val intent = Intent(Intent.ACTION_VIEW, callLogUri)
            startActivity(intent)
        }

        val galleryButton = findViewById<Button>(R.id.gallery)
        galleryButton.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_VIEW)
            galleryIntent.type = "image/*"
            startActivity(galleryIntent)
        }
        val cameraButton = findViewById<Button>(R.id.camera)
        cameraButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }

        val alarmButton = findViewById<Button>(R.id.alarm)
        alarmButton.setOnClickListener {
            val alarmIntent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(alarmIntent)
        }

        val loginButton = findViewById<Button>(R.id.loginbtn)
        loginButton.setOnClickListener {
            Intent(this, LoginActivity::class.java)
                .putExtra("email","kirtansantoki12@gmail.com")
                .putExtra("password","123456")
                .also {
                    startActivity(it)
                }
        }
    }
}