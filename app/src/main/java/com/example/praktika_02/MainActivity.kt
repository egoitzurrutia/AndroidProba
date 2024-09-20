package com.example.praktika_02

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var EmaitzaBotoia: Button
    lateinit var Textua: TextView
    lateinit var zenbakia1EditText: EditText
    lateinit var zenbakia2EditText: EditText
    lateinit var biderketa: CheckBox
    lateinit var zatiketa: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EmaitzaBotoia = findViewById(R.id.eragiketaegin)
        Textua = findViewById(R.id.emaitza)
        zenbakia1EditText = findViewById(R.id.zenbakia1)
        zenbakia2EditText = findViewById(R.id.zenbakia2)
        biderketa = findViewById(R.id.biderketa)
        zatiketa = findViewById(R.id.zatiketa)

        zatiketa.setOnClickListener {
            if (biderketa.isChecked) {
                biderketa.isChecked = false
            }
        }
        biderketa.setOnClickListener {
            if (zatiketa.isChecked) {
                zatiketa.isChecked = false
            }
        }

        EmaitzaBotoia.setOnClickListener {
            val zenbakia1Txt = zenbakia1EditText.text.toString()
            val zenbakia2Txt = zenbakia2EditText.text.toString()

            if (zenbakia1Txt.isEmpty() || zenbakia2Txt.isEmpty()) {
                Textua.text = "Mesedez, sartu bi zenbakiak"
                return@setOnClickListener
            }

            val zenbakia1 = zenbakia1Txt.toDouble()
            val zenbakia2 = zenbakia2Txt.toDouble()
            val emaitza = when {
                biderketa.isChecked -> zenbakia1 * zenbakia2
                zatiketa.isChecked -> zenbakia1 / zenbakia2
                else -> {
                    Textua.text = "Mesedez, aukeratu eragiketa bat"
                    return@setOnClickListener
                }
            }
            Textua.text = "Emaitza: $emaitza"
        }
    }
}