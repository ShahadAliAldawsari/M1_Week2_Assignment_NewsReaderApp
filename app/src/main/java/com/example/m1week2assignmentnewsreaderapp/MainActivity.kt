package com.example.m1week2assignmentnewsreaderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.m1week2assignmentnewsreaderapp.ui.theme.M1Week2AssignmentNewsReaderAppTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import androidx.compose.material3.ExperimentalMaterial3Api as ExperimentalMaterial3Api1


class MainActivity : ComponentActivity() {

    //To deal with this error: This material API is experimental and is likely to change or to be removed in the future.
    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navCtrl =  rememberNavController()
            val isLightTheme = remember {mutableStateOf(value=true)}
            M1Week2AssignmentNewsReaderAppTheme(darkTheme = !isLightTheme.value) {

                //this value will be added to the nestedScroll()
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )

                // navigating between screens

                // a well explained tutorial for the traditional way to implement navigation and passing values
                    // https://www.youtube.com/watch?v=wJKwsI5WUI4

                // a tutorial for the newest convenient way to implement navigation and passing values
                    // https://www.youtube.com/watch?v=AIC_OFQ1r3k

                NavHost(navController = navCtrl, startDestination = main_screen,
                    builder = {
                        composable<main_screen>{
                            MainScreen(getAllNews(), isLightTheme, navCtrl)
                        }

                        composable<second_screen>{
                            val args = it.toRoute<second_screen>()
                            SecondScreen(getAllNews()[args.news_index], isLightTheme)

                        }
                    }
                    )

            }
        }
    }
}

@Serializable
object main_screen

@Serializable
data class second_screen(
    val news_index: Int
)
//
//object Routes {
//    var main_screen = "main_screen"
//    var second_screen = "second_screen"
//    var new0_screen = "new0_screen"
//    var new1_screen = "new1_screen"
//    var new2_screen = "new2_screen"
//    var new3_screen = "new3_screen"
//    var new4_screen = "new4_screen"
//    var new5_screen = "new5_screen"
//    var new6_screen = "new6_screen"
//    var new7_screen = "new7_screen"
//
//
//}
