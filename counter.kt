package com.example.counterapp

import android.os.CountDownTimer // important 

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val timer = MyCounter(10000,1000)
    var countervalue: Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            timer.start()
            startBtn.isEnabled = false
            resetBtn.isEnabled = false //my addition
        }

        stopBtn.setOnClickListener {
            timer.cancel()
            startBtn.isEnabled = true
            resetBtn.isEnabled = true  //my addition
        }

        resetBtn.setOnClickListener {
            timer.cancel()
            startBtn.isEnabled=true
            countervalue=0
            displayValue.text=countervalue.toString()

        }

    }
    inner class MyCounter(millisInFuture: Long,countDownInterval: Long) :
        CountDownTimer(millisInFuture,countDownInterval) {
        override fun onFinish() {
        }

        override fun onTick(millisUntilFinished: Long) {
            countervalue++
            displayValue.text = (countervalue).toString()
        }
    }

}