package com.example.hw6

import android.content.Context
import android.content.SharedPreferences
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import java.util.jar.Attributes


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var sharedPreferences: SharedPreferences
     lateinit var editorSharedPreferences: SharedPreferences.Editor
    lateinit var editTextName: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var save_reservation_button: Button

    private var A_KEY = "KEY7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences =
            this.getSharedPreferences("com.example.mysharedprefapp", Context.MODE_PRIVATE)
        editorSharedPreferences = sharedPreferences.edit()



        editTextName = findViewById(R.id.editTextName)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        save_reservation_button = findViewById(R.id.save_reservation_button)

        save_reservation_button.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        var name = editTextName.text
        var room_number = editText2.text
        var date = editText3.text
        var price = editText4.text

        val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
        val Name = editTextName.text.toString()
        val Room_Number = editText2.text.toString()
        val Date = editText3.text.toString()
        val Price = editText4.text.toString()
        editorSharedPreferences.putString(A_KEY,"$Name, $Room_Number, $Date, $Price ").commit()

        intent.putExtra("Name", Name)
        intent.putExtra("Room_Number", Room_Number)
        intent.putExtra("Date", Date)
        intent.putExtra("Price", Price)
        startActivity(intent)


    }

}
