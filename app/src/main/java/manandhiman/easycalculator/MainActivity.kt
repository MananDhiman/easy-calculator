package manandhiman.easycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import manandhiman.easycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private var operation: String = "+"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.buttonResult.setOnClickListener {
      handleResultCalculation()
    }
  }

  private fun handleResultCalculation() {
    val value1 = binding.editTextNumber1.text
    val value2 = binding.editTextNumber2.text

    if(!valuesEntered(value1, value2)) {
      Toast.makeText(this, "Please Enter Numbers in Both Fields", Toast.LENGTH_LONG).show()
      return
    }
value1
    val number1: Double = value1.toString().toDouble()
    val number2: Double = value2.toString().toDouble()

    val result = getResult(number1, number2)

    binding.textView.text = result.toString()
  }

  private fun valuesEntered(value1: Editable, value2: Editable) : Boolean {
    return value1.isNotEmpty() && value2.isNotEmpty()
  }

  private fun getResult(num1: Double, num2: Double): Double {
    return when(operation) {
      "+" -> num1+num2
      "-" -> num1-num2
      "*" -> num1*num2
      "/" -> num1/num2
      else -> -1.0
    }
  }

  fun setOperation(view: View) {
    operation = view.tag.toString()
  }
}