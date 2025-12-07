package com.example.uikit.UI

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

data class Typo(
    val Title1_SemiBold: TextStyle = TextStyle(),
    val Title1_ExtraBold: TextStyle = TextStyle(),
    val Title2_Regular: TextStyle = TextStyle(),
    val Title2_SemiBold: TextStyle = TextStyle(),
    val Title2_ExtraBold: TextStyle = TextStyle(),
    val Title3_Regular: TextStyle = TextStyle(),
    val Title3_Medium: TextStyle = TextStyle(),
    val Title3_Semibold: TextStyle = TextStyle(),
    val Headline_Regular: TextStyle = TextStyle(),
    val Headline_Medium: TextStyle = TextStyle(),
    val Text_Regular: TextStyle = TextStyle(),
    val Text_Medium: TextStyle = TextStyle(),
    val Caption_Regular: TextStyle = TextStyle(),
    val Caption_Semibold: TextStyle = TextStyle(),
    val Caption2_Regular: TextStyle = TextStyle(),
    val Caption2_Bold: TextStyle = TextStyle(),
)

@Composable
fun Typography(): Typo{
    return Typo(
        Title1_SemiBold = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.semibold)),
            lineHeight = 28.sp,
            letterSpacing = 0.33.sp,
            fontWeight = FontWeight(600),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title1_ExtraBold = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.extrabold)),
            lineHeight = 28.sp,
            letterSpacing = 0.33.sp,
            fontWeight = FontWeight(800),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title2_Regular = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.regular)),
            lineHeight = 28.sp,
            letterSpacing = 0.38.sp,
            fontWeight = FontWeight(400),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title2_SemiBold = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.semibold)),
            lineHeight = 28.sp,
            letterSpacing = 0.38.sp,
            fontWeight = FontWeight(600),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title2_ExtraBold = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.extrabold)),
            lineHeight = 28.sp,
            letterSpacing = 0.38.sp,
            fontWeight = FontWeight(800),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title3_Regular = TextStyle(
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.regular)),
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(400),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title3_Medium = TextStyle(
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.medium)),
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(500),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Title3_Semibold = TextStyle(
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.semibold)),
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(600),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Headline_Regular = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.regular)),
            lineHeight = 20.sp,
            letterSpacing = -0.32.sp,
            fontWeight = FontWeight(400),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Headline_Medium = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.medium)),
            lineHeight = 20.sp,
            letterSpacing = -0.32.sp,
            fontWeight = FontWeight(500),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Text_Regular = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.regular)),
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(400),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Text_Medium = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.medium)),
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(400),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Caption_Regular = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.regular)),
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(400),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Caption_Semibold = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.semibold)),
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(600),
            //color = MaterialTheme.colorScheme.tertiary
        ),
        Caption2_Regular = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.regular)),
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(400),
           // color = MaterialTheme.colorScheme.tertiary
        ),
        Caption2_Bold = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.bold)),
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight(700),
            //color = MaterialTheme.colorScheme.tertiary
        ),








    )



}
