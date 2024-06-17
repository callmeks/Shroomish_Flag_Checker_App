package com.example.shroomish_flag_checker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shroomish_flag_checker.ui.theme.Shroomish_Flag_CheckerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shroomish_Flag_CheckerTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    CustomA(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomA( modifier: Modifier = Modifier) {

    Image(painter = painterResource(id = R.drawable.shroomish), contentDescription = null
    , modifier = modifier.fillMaxSize() )

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){

        var a by remember { mutableStateOf("") }
        val wee = LocalContext.current.applicationContext
        OutlinedTextField(
            value = a,
            onValueChange = { a = it },
            label = { Text("Flag check") },
            shape = RoundedCornerShape(20.dp),
            modifier = modifier
                .fillMaxWidth().background(color = Color.White,shape = RoundedCornerShape(20.dp))
        )

        Button(onClick = {
            if(wee().eee(wee().ed(a))){
                Toast.makeText(wee, "Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(wee, "Nope", Toast.LENGTH_SHORT).show()
            }
        }, colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(start=60.dp, end=60.dp,top=8.dp, bottom=8.dp),
            modifier = modifier.padding(bottom=200.dp)
        ){
            Text(text = "Check Flag", fontSize = 22.sp, color = Color.White)
        }
    }

}