package com.example.motivateme

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //declare our refernces to views before layout inflation
    private lateinit var name: EditText
    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get a reference to the button view from our layout and set a click Listener
        val updateButton : Button = findViewById(R.id.activity_main_bt_update)
        updateButton.setOnClickListener { updateMessage() }

        //Set the value to our declared views
        name = findViewById(R.id.activity_main_et_name);
        message = findViewById(R.id.main_activity_tv_message)
        val name:EditText = findViewById(R.id.activity_main_et_name)
        //val message: TextView = findViewById(R.id.main_activity_tv_message)
        val message=findViewById<TextView>(R.id.main_activity_tv_message)

    }

    //Get a name from an  editText and display a personalized message
    private fun updateMessage(){

        //Get the username from the edit text
        val username = name.text

        //Pick a motivational message
        val motivationalMessages = listOf("Keep working hard","Don’t Let Yesterday Take Up Too Much Of Today","Never Give Up",
            "Difficulty is growth","The Best Way To Get Started Is To Quit Talking And Begin Doing",
             "You Learn More From Failure Than From Success. Don’t Let It Stop You. Failure Builds Character.",
              "It’s Not Whether You Get Knocked Down, It’s Whether You Get Up")

        val arrayLength = motivationalMessages.size

        val index = (0 until (arrayLength)).random()

        val currentMessage = motivationalMessages[index];


        if(username.toString() == ""){
            message.text="Make Sure to enter your name!"
        } else{
            message.text = "Hello $username! $currentMessage"
        }
        //update the textview to display our message

        //Clear the edittext and use setText because edit text require an editable
        name.setText("");

        hideKeyboard();
    }

    //Hide the keyboard using an InputMethodManager
    private fun hideKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }

}