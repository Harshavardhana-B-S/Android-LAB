package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Important Imports
import android.text.Editable
import android.widget.Button
import android.widget.Toast
import android.view.View as View1

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View1.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnOne = findViewById<Button>(R.id.btnOne)
        btnOne.setOnClickListener(this)

        val btnTwo = findViewById<Button>(R.id.btnTwo)
        btnTwo.setOnClickListener(this)

        val btnThree = findViewById<Button>(R.id.btnThree)
        btnThree.setOnClickListener(this)

        val btnFour = findViewById<Button>(R.id.btnFour)
        btnFour.setOnClickListener(this)

        val btnFive = findViewById<Button>(R.id.btnFive)
        btnFive.setOnClickListener(this)

        val btnSix = findViewById<Button>(R.id.btnSix)
        btnSix.setOnClickListener(this)

        val btnSeven = findViewById<Button>(R.id.btnSeven)
        btnSeven.setOnClickListener(this)

        val btnEight = findViewById<Button>(R.id.btnEight)
        btnEight.setOnClickListener(this)

        val btnNine = findViewById<Button>(R.id.btnNine)
        btnNine.setOnClickListener(this)

        val btnZero = findViewById<Button>(R.id.btnZero)
        btnZero.setOnClickListener(this)

        val btnPoint = findViewById<Button>(R.id.btnPoint)
        btnPoint.setOnClickListener(this)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener(this)

        val btnSub = findViewById<Button>(R.id.btnSub)
        btnSub.setOnClickListener(this)

        val btnMul = findViewById<Button>(R.id.btnMul)
        btnMul.setOnClickListener(this)

        val btnDiv = findViewById<Button>(R.id.btnDiv)
        btnDiv.setOnClickListener(this)

        val btnEquals = findViewById<Button>(R.id.btnEquals)
        btnEquals.setOnClickListener(this)

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener(this)

    }

    override fun onClick(v: View1){
        if (v == btnOne)
            editTextText.append("1")
        if (v == btnTwo)
            editTextText.append("2")
        if (v == btnThree)
            editTextText.append("3")
        if (v == btnFour)
            editTextText.append("4")
        if (v == btnFive)
            editTextText.append("5")
        if (v == btnSix)
            editTextText.append("6")
        if (v == btnSeven)
            editTextText.append("7")
        if (v == btnEight)
            editTextText.append("8")
        if (v == btnNine)
            editTextText.append("9")
        if (v == btnZero)
            editTextText.append("0")

        if (v == btnPoint)
            editTextText.append(".")


        if (v == btnAdd)
            editTextText.append("+")
        if (v == btnSub)
            editTextText.append("-")
        if (v == btnMul)
            editTextText.append("*")
        if (v == btnDiv)
            editTextText.append("/")

        if (v == btnClear) {
            editTextText.text.clear()
        }


        if (v == btnEquals) {
            try {
                val data = editTextText.text.toString()
                when {
                    data.contains("/") -> divide(data)
                    data.contains("*") -> multiplication(data)
                    data.contains("+") -> addition(data)
                    data.contains("-") -> subtraction(data)
                }
            } catch (e: Exception) {
                displayInvalidMessage("Invalid Input")
            }
        }
    }

    private fun displayInvalidMessage(mes: String) {
        Toast.makeText(applicationContext, mes, Toast.LENGTH_LONG).show()
    }

    private fun addition(data: String) {
        val operands = data.split("+")
        if (operands.size == 2) {
            val operand1 = operands[0].toDouble()
            val operand2 = operands[1].toDouble()
            val result = operand1 + operand2
            val editableResult = Editable.Factory.getInstance().newEditable(result.toString())
            editTextText.text = editableResult
        } else {
            displayInvalidMessage("Invalid Input")
        }
    }


    private fun subtraction(data: String) {
        val operands = data.split("-")
        if (operands.size == 2) {
            val operand1 = operands[0].toDouble()
            val operand2 = operands[1].toDouble()
            val result = operand1 - operand2
            val editableResult = Editable.Factory.getInstance().newEditable(result.toString())
            editTextText.text = editableResult
        } else {
            displayInvalidMessage("Invalid Input")
        }
    }

    private fun multiplication(data: String) {
        val operands = data.split("*")
        if (operands.size == 2) {
            val operand1 = operands[0].toDouble()
            val operand2 = operands[1].toDouble()
            val result = operand1 * operand2
            val editableResult = Editable.Factory.getInstance().newEditable(result.toString())
            editTextText.text = editableResult
        } else {
            displayInvalidMessage("Invalid Input")
        }
    }

    private fun divide(data: String) {
        val operands = data.split("/")
        if (operands.size == 2) {
            val operand1 = operands[0].toDouble()
            val operand2 = operands[1].toDouble()
            val result = operand1 / operand2
            val editableResult = Editable.Factory.getInstance().newEditable(result.toString())
            editTextText.text = editableResult
        } else {
            displayInvalidMessage("Invalid Input")
        }
    }


}