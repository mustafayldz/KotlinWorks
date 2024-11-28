package com.example.drumstar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//this class will manage the values displayed in the user interface
class ViewModelTemperatures: ViewModel() {

    // state of the toggle switch
    var isFahrenheit by mutableStateOf(true)
    // calculated result
    var convertedTemperatures by mutableStateOf("")

    // change the state of the temperature
    fun doSwitchToggle() {
        isFahrenheit = !isFahrenheit
    }

    //calculate the temperature when the calculate button is pressed
    fun calculateConversion(inputValue: String) {

        try {
            //if the input value is empty, return
            if (inputValue.isEmpty()) {
                convertedTemperatures = ""
            }
            //convert the input value to a double
            val input = inputValue.toDouble()
            //convert the temperature
            val result = if (isFahrenheit) {
                "%.2f".format( (input - 32) * 5 / 9)
            } else {
                "%.2f".format( input * 9 / 5 + 32)
            }
            //set the result to the convertedTemperatures
            convertedTemperatures = result + if (isFahrenheit) "\u2103 " else "\u2109"


        }catch (e: NumberFormatException) {
            convertedTemperatures = "Invalid input"
        }


    }




}