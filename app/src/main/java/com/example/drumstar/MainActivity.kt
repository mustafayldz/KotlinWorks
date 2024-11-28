package com.example.drumstar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.drumstar.ui.theme.DrumStarTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrumStarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background


                ) {

                    MyApp()

/*
                    BusinessCard()
*/

/*
    //Compose quadrant
                   ComposeQuadrant()
*/


/*
                    // Task Manager
                    TaskManager(Modifier)
*/



      /*
// Compose Article
                    ComposeArticle(Modifier)
              */


/*
 // Birthday Card
                        GreetingImage(
                            message = getString(R.string.happy_birthday) + "Sam!",
                            from = "From Emma"
                        )

 */
                    }
                }
            }
        }
    }





// MyApp -------------------------------------------------------------------------------------------

@Composable
fun MyApp() {

    var viewModel: ViewModelTemperatures = viewModel()

    MainScreen(
        isFahrenheit = viewModel.isFahrenheit,
        result = viewModel.convertedTemperatures,
        convertTemp = { viewModel.calculateConversion(it) },
        toggleSwitch = { viewModel.doSwitchToggle() }
    )


}

@Composable
fun MainScreen(
    isFahrenheit: Boolean,
    result: String,
    convertTemp: (String) -> Unit,
    toggleSwitch: () -> Unit) {

    var inputTextState by remember { mutableStateOf("") }

    // update the value of the input text
    fun onTextChange(text: String) {
        inputTextState = text
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Temperature Converter", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 9.dp),
            colors = CardDefaults.cardColors(Color.White),

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(16.dp)
            ) {
                Switch(checked = isFahrenheit, onCheckedChange = { toggleSwitch() })
                OutlinedTextField(
                    value = inputTextState,
                    onValueChange = { onTextChange(it) },
                    label = { Text("Enter a temperature") },
                    modifier = Modifier.padding(16.dp),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    trailingIcon = {
                        Text(
                            text = if (isFahrenheit) "\u2109" else "\u2103",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    )
            }
        }

        Text(text = "Result: $result", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { convertTemp(inputTextState) }, modifier = Modifier.padding(16.dp)) {
            Text(text = "Calculate")
        }

    }
}


// Business Card -----------------------------------------------------------------------------------
@Composable
fun BusinessCard() {
    val image = painterResource(id = R.drawable.android_logo)

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E7D4))
    ) {

        Spacer(modifier = Modifier)
        Spacer(modifier = Modifier)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .fillMaxSize(0.12f)
                    .background(Color(0xFF083041))
            ) {
                    Image(painter = image, contentDescription = "")

            }

            Text(text = "Mustafa Yildiz",
                fontWeight = FontWeight.W300,
                fontSize = 32.sp
                )
            Text("Android Developer Extraordinaire", color = Color(0xFF156E3B))
        }

        Spacer(modifier = Modifier)

        Column{
            Row {
                Icon(Icons.Filled.Call , contentDescription = "",
                    tint = Color(0xFF156E3B)
                    )
                Spacer(Modifier.padding(horizontal = 5.dp))
                Text(text = "+1 (6477748407)")
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row {
                Icon(Icons.Filled.Share, contentDescription = "",
                    tint = Color(0xFF156E3B)
                )
                Spacer(Modifier.padding(horizontal = 5.dp))
                Text(text = "@mstfyldz")
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row {
                Icon(Icons.Filled.Email, contentDescription = "",
                    tint = Color(0xFF156E3B)
                )
                Spacer(Modifier.padding(horizontal = 5.dp))
                Text(text = "mstf.yildiz92@gmail.com")
            }
        }

    }
}



// Compose Quadrant --------------------------------------------------------------------------------
@Composable
fun ComposeQuadrant() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            ComposeQuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrantCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            ComposeQuadrantCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrantCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun ComposeQuadrantCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            fontSize = 14.sp
        )
    }
}



// Task Manager ------------------------------------------------------------------------------------
@Composable
fun TaskManager( modifier: Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
            Image(painter = image, contentDescription = "")
            Text(
                text = "All tasks completed\n",
                fontWeight = FontWeight.Bold,
                modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
            Text(text = "Nice work!\n", fontSize = 16.sp)
        }


}



// Compose Article ---------------------------------------------------------------------------------
@Composable
fun ComposeArticle(modifier: Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
            )

        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
            )

        Text(text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
            )

        Text(text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}









// Birthday Card Greeting --------------------------------------------------------------------------
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8f,

        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}





