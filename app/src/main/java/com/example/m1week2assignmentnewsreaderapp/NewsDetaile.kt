package com.example.m1week2assignmentnewsreaderapp

import android.content.ClipData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.w3c.dom.Text
import kotlin.math.round

//to deal with this error: This material API is experimental and is likely to change or to be removed in the future.
@ExperimentalMaterial3Api
@Composable
fun SecondScreen(newsObject: NewsObject,
                 isLightTheme: MutableState<Boolean>
){
    //this value will be added to the nestedScroll()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    val isSaved = remember { mutableStateOf(false) }
    
    Scaffold (
        modifier = Modifier
            /*this line will give wider screen by removing
             the top bar away when scrolling down and git it
             back when scrolling up*/
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        // calling the top bar fun
        topBar = {
            SecondTopMenu(
                scrollBehavior = scrollBehavior,
                isLight = isLightTheme.value){isLightTheme.value = !isLightTheme.value}
            }
    ){paddingValues ->
        NewsDetail(newsObject,
            modifier = Modifier
                .padding(top=paddingValues.calculateTopPadding()+14.dp)
        )
    }


}


//to deal with this error: This material API is experimental and is likely to change or to be removed in the future.
@ExperimentalMaterial3Api
@Composable
fun SecondTopMenu(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    isLight: Boolean, onThemeToggle:()->Unit,
){
    TopAppBar(
        modifier=modifier,
//            .padding(horizontal = 8.dp),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.secondaryContainer), //secondaryContainer
        title = {
            Text(
                text = UiText.StringResource(R.string.screen2).asString(),
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = FontFamily.Serif,
                fontWeight = SemiBold
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

        actions = {

        // bookmark "save" icon before the end of the bar
        var isSaved by remember { mutableStateOf(false) }
            Button(
                onClick = {isSaved = !isSaved},
                modifier = Modifier.padding(0.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent)

            ){
                var id = R.drawable.save_icon
                if (isSaved) id = R.drawable.saved_icon
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = "search icon",
                        modifier = Modifier
                            .padding(0.dp)
                            .width(28.dp)
                            .height(28.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

            //dark & light themes switcher icon at the end of the bar
            Button(
                onClick = onThemeToggle,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.padding(0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sunmoon2),
                    contentDescription = "sun and moon icon",
                    modifier = Modifier
                        .padding(0.dp)
                        .width(28.dp)
                        .height(28.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

        }

    )
}


@Composable
fun NewsDetail (newsObject: NewsObject, modifier: Modifier=Modifier)
{

        Column(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)

                //this will allow scrolling when the content is larger than its container
                .verticalScroll(rememberScrollState())
        ) {
            //News image
            AsyncImage(
                model = newsObject.imageLink,
                contentDescription = "the news image link",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),

                // this line will center crop the image into the available space.
                contentScale = ContentScale.FillWidth,
            )

            //Text for the title
            Card(
                modifier=Modifier
                    .fillMaxWidth(),
//                    .padding(8.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(
                    text = newsObject.news_title.asString(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = FontFamily.Serif,
                    fontWeight = SemiBold,
                    modifier = Modifier.padding(8.dp)
                )
            }

            //Text for the date
            Text(
                text = newsObject.news_date.asString(),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Spacer(Modifier.height(16.dp))
            //Text for news content
                Text(
                    text = newsObject.news_content.asString(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily.Serif, //SansSerif,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )

        }

}