package com.example.motivateme

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get a reference to the button view from our layout and set a click Listener
        val updateButton : Button = findViewById(R.id.activity_main_bt_update)
        updateButton.setOnClickListener { updateMessage() }
    }

    //Get a name from an  editText and display a personalized message
    private fun updateMessage(){
        val name:EditText = findViewById(R.id.activity_main_et_name)
        //val message: TextView = findViewById(R.id.main_activity_tv_message)
        val message=findViewById<TextView>(R.id.main_activity_tv_message)

        //Get the username from the edit text
        val username = name.text

        //update the textview to display our message
        message.text = "Hello $username!"
    }

}