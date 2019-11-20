package com.example.hw6

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.*
import java.util.*
import java.util.jar.Attributes

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editorSharedPreferences: SharedPreferences.Editor
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var delete_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sharedPreferences =
            this.getSharedPreferences("com.example.mysharedprefapp", Context.MODE_PRIVATE)
        editorSharedPreferences = sharedPreferences.edit()

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        delete_button = findViewById(R.id.delete_button)

        val intentObject : Intent = intent

        val Name = intentObject.getStringExtra("Name")
        val Room_Numer = intentObject.getStringExtra("Room_Number")
        val Date = intentObject.getStringExtra("Date")
        val Price = intentObject.getStringExtra("Price")

        textView1.text = "$Name"
        textView2.text = "$Room_Numer"
        textView3.text = "$Date"
        textView4.text = "$Price"

        delete_button.setOnClickListener(this)
    }




    override fun onClick(view: View?) {

        val intent: Intent = Intent(applicationContext, ThirdActivity::class.java)
        clearFindViewByIdCache()


        startActivity(intent)
    }

}
