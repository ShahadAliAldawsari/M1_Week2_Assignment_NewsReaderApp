package com.example.m1week2assignmentnewsreaderapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlin.math.round

// main screen function
@ExperimentalMaterial3Api
@Composable
fun MainScreen (newsObjects:List<NewsObject>,
                isLightTheme: MutableState<Boolean>,
                navCtrl: NavController
){
    //this value will be added to the nestedScroll()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    //Screen Header or the Top Bar/////////////////////////////
    Scaffold (
        modifier = Modifier
            /*this line will give wider screen by removing
             the top bar away when scrolling down and git it
             back when scrolling up*/
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        // calling the top bar fun
        topBar = {
            PrimaryTopMenu(
                scrollBehavior = scrollBehavior,
                isLight = isLightTheme.value
            ){isLightTheme.value = !isLightTheme.value}
        }
    )

    //Screen Body /////////////////////////////////////////////
    { paddingValues ->
        LazyColumn (modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingValues.calculateTopPadding() + 14.dp),
        ) {
            items(items = newsObjects){
                    news-> NewsItem(news, navCtrl)
            }
        }
    }

}


@ExperimentalMaterial3Api //to deal with this error: This material API is experimental and is likely to change or to be removed in the future.
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



// this function is for the unified design for all the news items
@Composable
fun NewsItem(newsItem: NewsObject, navCtrl: NavController ){

    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier.fillMaxWidth()
            .height(215.dp)
            .padding(16.dp, 7.dp, 16.dp, 7.dp)
    )
    {
        // Row for all the news headline content (title, date, image)
        Row(
            modifier = Modifier
                .padding(8.dp)
        ){

            Button(
                onClick = {
                    navCtrl.navigate(second_screen(
                        news_index = newsItem.new_id
                    ))
                },
                modifier = Modifier
                    .padding(0.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(0),
                contentPadding = PaddingValues(0.dp)
            ) {
                //column for the title and date
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(235.dp),
                ) {

                    //the news title
                    Text(
                        text = newsItem.news_title.asString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = FontFamily.Serif,
                        fontWeight = SemiBold,
                        color = MaterialTheme.colorScheme.onBackground,

//                    //This line will expand each line to ensure equal lines length
//                    //I like it more without it,
//                    //but I will keep it in case I changed my mind
//                    textAlign = TextAlign.Justify,

                        //Pushes everything below to the bottom
                        //This forces the date text to stick to the bottom of the column
                        modifier = Modifier.weight(1f)
                    )

                    //the news date
                    Text(
                        text = newsItem.news_date.asString(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                    )
                }
            }


            Spacer(Modifier.width(8.dp))

            //the news image
            AsyncImage(
                model =newsItem.imageLink,
                contentDescription = "The news image",

                // this line will center crop the image into the available space.
                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .fillMaxHeight()
                    .height(30.dp)
            )

        }
    }
}