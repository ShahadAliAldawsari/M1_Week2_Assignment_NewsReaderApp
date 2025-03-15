package com.example.m1week2assignmentnewsreaderapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

data class NewsObject(
    val new_id: Int,
    val news_title: UiText,
    val news_content: UiText,
    val news_category: UiText,
    val news_date: UiText,
    val imageLink: String
)


    @Composable
    fun getAllNews(): List<NewsObject>{
        val context = LocalContext.current
        return listOf(
            NewsObject(
                new_id=0,
                news_title= UiText.StringResource(resId = R.string.title_1),
                news_content= UiText.StringResource(resId = R.string.news_1),
                news_category= UiText.StringResource(resId = R.string.category_1),
                news_date= UiText.StringResource(resId = R.string.date_1),
                imageLink = "https://noskhabar.com/wp-content/uploads/2025/03/0-1.webp"

            ),

            NewsObject(
                new_id=1,
                news_title= UiText.StringResource(resId = R.string.title_2),
                news_content= UiText.StringResource(resId = R.string.news_2),
                news_category= UiText.StringResource(resId = R.string.category_2),
                news_date= UiText.StringResource(resId = R.string.date_2),
                imageLink = "https://twice.ma/wp-content/uploads/2023/06/1685845099_785_%D8%B5%D9%88%D8%B1-%D8%B9%D9%84%D9%85-%D8%A7%D9%84%D8%B3%D8%B9%D9%88%D8%AF%D9%8A%D8%A9-HD-%D8%A7%D8%AC%D9%85%D9%84-%D8%AE%D9%84%D9%81%D9%8A%D8%A7%D8%AA-%D8%B9%D9%84%D9%85-%D8%A7%D9%84%D8%B3%D8%B9%D9%88%D8%AF%D9%8A%D8%A9.jpg"
            ),

            NewsObject(
                new_id=2,
                news_title= UiText.StringResource(resId = R.string.title_3),
                news_content= UiText.StringResource(resId = R.string.news_3),
                news_category= UiText.StringResource(resId = R.string.category_3),
                news_date= UiText.StringResource(resId = R.string.date_3),
                imageLink = "https://media.assettype.com/sabq%2F2025-01-16%2F00dhyynn%2FJ3cGc4bfDyqdnttUcHSstwpwPQKNiRAiKeH5SCiU.jpg?w=1024&auto=format%2Ccompress&fit=max"
            ),

            NewsObject(
                new_id=3,
                news_title= UiText.StringResource(resId = R.string.title_4),
                news_content= UiText.StringResource(resId = R.string.news_4),
                news_category= UiText.StringResource(resId = R.string.category_4),
                news_date= UiText.StringResource(resId = R.string.date_4),
                imageLink = "https://images.unsplash.com/photo-1498100152307-ce63fd6c5424?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            NewsObject(
                new_id=4,
                news_title= UiText.StringResource(resId = R.string.title_1, ),
                news_content= UiText.StringResource(resId = R.string.news_1),
                news_category= UiText.StringResource(resId = R.string.category_1),
                news_date= UiText.StringResource(resId = R.string.date_1),
                imageLink = "https://noskhabar.com/wp-content/uploads/2025/03/0-1.webp"

            ),

            NewsObject(
                new_id=5,
                news_title= UiText.StringResource(resId = R.string.title_2),
                news_content= UiText.StringResource(resId = R.string.news_2),
                news_category= UiText.StringResource(resId = R.string.category_2),
                news_date= UiText.StringResource(resId = R.string.date_2),
                imageLink = "https://twice.ma/wp-content/uploads/2023/06/1685845099_785_%D8%B5%D9%88%D8%B1-%D8%B9%D9%84%D9%85-%D8%A7%D9%84%D8%B3%D8%B9%D9%88%D8%AF%D9%8A%D8%A9-HD-%D8%A7%D8%AC%D9%85%D9%84-%D8%AE%D9%84%D9%81%D9%8A%D8%A7%D8%AA-%D8%B9%D9%84%D9%85-%D8%A7%D9%84%D8%B3%D8%B9%D9%88%D8%AF%D9%8A%D8%A9.jpg"
            ),

            NewsObject(
                new_id=6,
                news_title= UiText.StringResource(resId = R.string.title_3),
                news_content= UiText.StringResource(resId = R.string.news_3),
                news_category= UiText.StringResource(resId = R.string.category_3),
                news_date= UiText.StringResource(resId = R.string.date_3),
                imageLink = "https://media.assettype.com/sabq%2F2025-01-16%2F00dhyynn%2FJ3cGc4bfDyqdnttUcHSstwpwPQKNiRAiKeH5SCiU.jpg?w=1024&auto=format%2Ccompress&fit=max"
            ),

            NewsObject(
                new_id=7,
                news_title= UiText.StringResource(resId = R.string.title_4),
                news_content= UiText.StringResource(resId = R.string.news_4),
                news_category= UiText.StringResource(resId = R.string.category_4),
                news_date= UiText.StringResource(resId = R.string.date_4),
                imageLink = "https://images.unsplash.com/photo-1498100152307-ce63fd6c5424?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )


        )
    }


