package com.example.calculator_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import com.example.calculator_14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    private fun onNumberClicked() {

        binding.btn0.setOnClickListener {

            if (binding.txtExpression.text.isNotEmpty()) {
                appendText("0")
            }

        }

        binding.btn1.setOnClickListener {
            appendText("1")
        }

        binding.btn2.setOnClickListener {
            appendText("2")
        }

        binding.btn3.setOnClickListener {
            appendText("3")
        }

        binding.btn4.setOnClickListener {
            appendText("4")
        }

        binding.btn5.setOnClickListener {
            appendText("5")
        }

        binding.btn6.setOnClickListener {
            appendText("6")
        }

        binding.btn7.setOnClickListener {
            appendText("7")
        }

        binding.btn8.setOnClickListener {
            appendText("8")
        }

        binding.btn9.setOnClickListener {
            appendText("9")
        }
    }
    private fun appendText(newText: String) {

        if (binding.txtJavab.text.isNotEmpty()) {
            binding.txtExpression.text = ""
        }

        binding.txtJavab.text = ""
        binding.txtExpression.append(newText)

        val viewTree: ViewTreeObserver = binding.horizontalScrollViewTxtExpression.viewTreeObserver
        viewTree.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalScrollViewTxtExpression.viewTreeObserver.removeOnGlobalLayoutListener(
                    this
                )
                binding.horizontalScrollViewTxtExpression.scrollTo(binding.txtExpression.width, 0)
            }
        })

    }




}