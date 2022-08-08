package com.example.agecalculatorapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.arch.core.executor.DefaultTaskExecutor
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var button:Button
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.clnbtn)
        button.setOnClickListener { view->
          printAge(view)
        }

    }
    private fun printAge(view: View){
      var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var day = myCalender.get(Calendar.DAY_OF_MONTH)

       //DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->  })

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, day ->
         var date = findViewById<TextView>(R.id.date)
            val selectedDate ="$day/${month+1}/$year"
            date.text=selectedDate

            var result = findViewById<TextView>(R.id.resulttv)
            var dob = Calendar.getInstance()
            dob.set(year,month,day)

            var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
            if(myCalender.get(Calendar.YEAR)<dob.get(Calendar.YEAR))
            {
                age--
            }
            result.text="You are $age year old"
        }

        , year,
            month,
            day).show()
    }
}