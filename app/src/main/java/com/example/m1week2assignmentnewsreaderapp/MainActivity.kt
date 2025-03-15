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
import androidx.compose.material3.ExperimentalMaterial3Api as ExperimentalMaterial3Api1


class MainActivity : ComponentActivity() {

    //To deal with this error: This material API is experimental and is likely to change or to be removed in the future.
    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isLightTheme = remember {mutableStateOf(value=true)}
            M1Week2AssignmentNewsReaderAppTheme(darkTheme = !isLightTheme.value) {

                //this line used to check while designing the news item card
                NewsItem(getAllNews()[2])

                //this value will be added to the nestedScroll()
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )
                val newsList = getAllNews()

                Scaffold (
                    modifier = Modifier
                        /*this line will give wider screen by removing
                         the top bar away when scrolling down and git it
                         back when scrolling up*/
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    // calling the top bar fun
                    topBar = {
                        PrimaryTopMenu(scrollBehavior = scrollBehavior,
                            isLight = isLightTheme.value
                        ){isLightTheme.value = !isLightTheme.value}
                    }
                ){

                    // the body of the screen:
                    // "paddingValues" will ensures proper padding between the top bar and the rest of the content
                    paddingValues ->
                    LazyColumn (modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = paddingValues.calculateTopPadding() + 14.dp),
                    ) {
                        items(items = newsList){
                                news-> NewsItem(news)
                        }
                    }
                }


                //this code used to check while designing the news detail screen
                SecondScreen(getAllNews()[3], scrollBehavior, isLightTheme)

            }
        }
    }
}

@ExperimentalMaterial3Api1 //to deal with this error: This material API is experimental and is likely to change or to be removed in the future.
@Composable
fun PrimaryTopMenu(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    isLight: Boolean, onThemeToggle:()->Unit
){
    TopAppBar(
        modifier = Modifier,
//            .padding(horizontal = 8.dp),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.secondaryContainer), //secondaryContainer
        title = {
            Text(
                text = UiText.StringResource(R.string.screen1).asString(),
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold
            )
        },
        //menu icon at the beginning of the bar
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "menu icon",
                modifier = Modifier
                    .padding(8.dp)
                    .width(32.dp)
                    .height(32.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        },
        //search icon before the end of the bar
        actions = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search icon",
                modifier = Modifier
//                    .padding(8.dp)
                    .width(32.dp)
                    .height(32.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )

            //dark & light themes switcher icon at the end of the bar
            Button(
                onClick = onThemeToggle,
                colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                Icon(
                    painter = painterResource(id = R.drawable.sunmoon2),
                    contentDescription = "sun and moon icon",
                    modifier = Modifier
//                        .padding(end = 8.dp)
                        .width(28.dp)
                        .height(28.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

        }

    )
}