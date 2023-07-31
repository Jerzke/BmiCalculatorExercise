package com.example.bmicalcula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmicalcula.ui.theme.BmicalculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmicalculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var height by remember{
        mutableStateOf("")
    }
    var weight by remember{
        mutableStateOf("")
    }
    var result by remember{
        mutableStateOf("")
    }
    var results by remember{
        mutableStateOf("")
    }
   Column(
       modifier = Modifier.padding(16.dp)
   ) {
       TextField(

           value = height,
           onValueChange = {height = it},
           label = {
               Text(text = "Height (M)")
           }
       )
       TextField(
           value = weight,
           onValueChange = {weight = it},
           label = {
               Text(text = "Weight (KG)")
           },
           modifier = Modifier.padding(top = 8.dp)
       )
       Button(onClick = {
                        results = calculateBmi(height = height.toDouble(),weight = weight.toDouble())
                        }, modifier = Modifier.padding(8.dp),) {
           Text(text = "Calculate")
       }
       if (result.isNotBlank()){
           Text(text = results)
       }
   }



}

@Preview
@Composable
fun MainScreenPreview() {
    BmicalculaTheme {
        MainScreen()
    }
    
}

private fun calculateBmi(height:Double,weight:Double):String{
    val bmiIndex = weight / (height * height)
    return "Your BMi index is $bmiIndex"
}
