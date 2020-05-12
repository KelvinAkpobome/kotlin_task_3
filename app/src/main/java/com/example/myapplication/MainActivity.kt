package com.example.myapplication

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);



       button3.setOnClickListener {
           val intent = Intent(this, Main2Activity::class.java)
           startActivity(intent)
       }



        Log.d("OnCreate", "The activity is in onCreate state")


        //setting listeners




        what.setOnClickListener {

            val contact = "+234 7065748014" // use country code with your phone number

            val url = "https://api.whatsapp.com/send?phone=$contact"
            try {
                this.packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)

                startActivity(i)


            } catch (e: PackageManager.NameNotFoundException) {
                Log.e("WS", "ERROR_OPEN_MESSANGER"+e.toString());
            }
        }



        yout.setOnClickListener {

            val isIntent: Intent= try {
                // Check if YT app is even installed
                this.packageManager.getPackageInfo("com.google.android.youtube", 0)
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))
            } catch (e: Exception) {

                // Cache and Open a url in browser
                val ytProfileUri = "https://www.youtube.com/"
                Intent(Intent.ACTION_VIEW, Uri.parse(ytProfileUri))
            }

            //verifies intent would resolve to at least one activity
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(isIntent, "Open With"))

            }
        }







        link.setOnClickListener {

            val lnIntent: Intent= try {
                // Check if linkedin app is even installed
                this.packageManager.getPackageInfo("com.linkedin.android", 0)
                Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://"))
            } catch (e: Exception) {
                val lnProfileUri = "https://www.linkedin.com/in/phildubem"
                Intent(Intent.ACTION_VIEW, Uri.parse(lnProfileUri))
            }

            //verifies intent would resolve to at least one activity
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(lnIntent, "Open With"))

            }
        }



    }

    override fun onStart() {
        super.onStart()

        Log.d("onStart", "The activity is in onStart state")
    }

    override fun onResume() {
        val sharedPref = getSharedPreferences(Main2Activity.USER_SHARED_PREF, Context.MODE_PRIVATE)
        val email = sharedPref.getString(Main2Activity.EMAIL, "N/A")
        textView2.text = email
            super.onResume()

        Log.d("OnResume", "The activity is in onResume state")
    }

    override fun onPause() {
        super.onPause()

        Log.d("OnPause", "The activity is in onPause state")
    }

    override fun onStop() {
        super.onStop()

        Log.d("onStop", "The activity is in onStop state")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("onDestroy", "The activity is in onDestroy state")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("onRestart", "The activity is in onRestart state")
    }


}
