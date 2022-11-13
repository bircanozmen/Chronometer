package com.bircanozmen.chronometerrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number=0
    var runnable : Runnable= Runnable {  } // initialize, this is abstract class
    var handler : Handler = Handler(Looper.getMainLooper()) // initialize, this is interface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {

        number = 0

        runnable = object : Runnable {
            override fun run() {

                number = number + 1
                textview.text = "Time: $number"

                handler.postDelayed(this,1000)

            }

        }

        handler.post (runnable)
        button1.isEnabled = false
        button2.isEnabled=true
        button3.isEnabled=true

    }
    fun stop(view: View){
        handler.removeCallbacks(runnable)
        textview.text= "$number seconds"
        button1.isEnabled=true
        button2.isEnabled=false

    }
  fun reset(view: View){
        
        handler.removeCallbacks(runnable)
        number=0
        textview.text="00:00.00"
        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=false


    }
}