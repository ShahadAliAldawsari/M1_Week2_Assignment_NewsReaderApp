package com.example.m1week2assignmentnewsreaderapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


// this function is for the unified design for the news items

@Composable
fun NewsItem(newsItem: NewsObject ){

    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier.fillMaxWidth()
            .height(215.dp)
            .padding(16.dp, 7.dp, 16.dp, 7.dp)
    )
    {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ){
            //column for the title and date
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(250.dp),
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

            Spacer(Modifier.width(16.dp))

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