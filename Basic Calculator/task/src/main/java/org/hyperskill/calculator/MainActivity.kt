package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text = ""
        val textField = findViewById<EditText>(R.id.editText)

        val listOfNumberButtons = listOf(
            findViewById<Button>(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
            findViewById(R.id.dotButton)
        )

        val listOfOperationButtons = listOf(
            findViewById<Button>(R.id.divideButton),
            findViewById(R.id.multiplyButton),
            findViewById(R.id.subtractButton),
            findViewById(R.id.addButton)
        )

        val equalButton = findViewById<Button>(R.id.equalButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        lateinit var firstValue: BigDecimal
        lateinit var secondValue: BigDecimal
        lateinit var operation: CharSequence


        listOfNumberButtons.forEach { button ->
            button.setOnClickListener {
                if ((text != "0" || button.text != "0") &&
                    (!text.contains(".") || button.text != ".")) {
                    text += button.text
                    textField.setText(text)
                }
            }
        }

        listOfOperationButtons.forEach { button ->
            button.setOnClickListener {
                if (text == "" && button.text == "-") {
                    text = "-"
                    textField.setText(text)
                } else {
                    firstValue = BigDecimal(text)
                    operation = button.text
                    text = ""
                    textField.setText(text)
                    textField.hint = firstValue.toString()
                }
            }
        }

        equalButton.setOnClickListener {
            secondValue = BigDecimal(text)
            when (operation) {
                "+" -> text = (firstValue + secondValue).toString()
                "-" -> text = (firstValue - secondValue).toString()
                "\u00D7" -> text = (firstValue * secondValue).toString()
                "\u00F7" -> text = (firstValue.setScale(7) / secondValue)
                    .stripTrailingZeros()
                    .toString()
            }
            textField.setText(text)
        }

        clearButton.setOnClickListener {
            text = ""
            textField.setText(text)
            textField.hint = "0"
        }

    }
}