package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class Main2Activity : AppCompatActivity() {

    companion object{
        const val USER_SHARED_PREF = "com.example.myapplication.PREFERENCES"
        const val EMAIL = "EMAIL"
        const val PASSWORD = "PASSWORD"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);
    }



    private fun saveToSharedPref(){
        val sharedPref = getSharedPreferences(USER_SHARED_PREF, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(EMAIL, findViewById<EditText>(R.id.username).text.toString())
        editor.putString(PASSWORD, findViewById<EditText>(R.id.password).text.toString())
        editor.apply()
    }


    fun signIn(view: View){
        saveToSharedPref()
        Toast.makeText(this, "You have been saved, Login now", Toast.LENGTH_LONG).show()
        login_button.isClickable = true

    }
    fun dashboard (view: View){
        val sharedPref = getSharedPreferences(Main2Activity.USER_SHARED_PREF, Context.MODE_PRIVATE)
        val email = sharedPref.getString(Main2Activity.EMAIL, "N/A")
        val password = sharedPref.getString(Main2Activity.PASSWORD, "N/A")
        if (email.equals(findViewById<EditText>(R.id.username).text.toString()) && password.equals(findViewById<EditText>(R.id.password).text.toString()) ){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
