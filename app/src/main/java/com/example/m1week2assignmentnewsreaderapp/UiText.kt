package com.example.m1week2assignmentnewsreaderapp

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


/*
using this sealed class I will be able to access string resources any where in the project
without using "context" to be able to support malty languages
*/

//here is the tutorial that I followed:
//https://www.youtube.com/watch?v=mB1Lej0aDus

sealed class UiText {

    //this class used with API resources
    // "I don't need it now but its good to have it though"
    data class DynamicResources(val value: String,): UiText()

    //this class used with string resources
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any
    ): UiText()


    /*this functions are used to access string resources
     from any where in the project*/

    // this one is to access from composed code
    @Composable
    fun asString(): String{
        return when(this) {
            is DynamicResources -> value
            is StringResource -> stringResource(resId, *args)
        }
    }

    // this one is to access from non-composed code
    fun asString(context: Context): String{
        return when(this) {
            is DynamicResources -> value
            is StringResource -> context.getString(resId)
        }
    }
}