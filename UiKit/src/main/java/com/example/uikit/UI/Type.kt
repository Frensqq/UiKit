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

    fun textStyle(
        fontSize: Int,
        fontWeight: Int,
        lineHeight: Int,
        letterSpacing: Double = 0.00,
        fontFamily: Int = R.font.regular
    ) = TextStyle(
        fontSize = fontSize.sp,
        fontWeight = FontWeight(weight = fontWeight),
        lineHeight = lineHeight.sp,
        letterSpacing = letterSpacing.sp,
        fontFamily = FontFamily(Font(fontFamily))
    )

    return Typo(
        Title1_SemiBold = textStyle(24,600,
            28, 0.33,R.font.semibold,
        ),
        Title1_ExtraBold = textStyle(24,800,
            28,0.33,R.font.extrabold,
        ),
        Title2_Regular = textStyle(20,400,
            28,0.38
        ),
        Title2_SemiBold = textStyle(20,600,
             28, 0.38, R.font.semibold
        ),
        Title2_ExtraBold = textStyle(20, 800,
            28, 0.38, R.font.extrabold
        ),
        Title3_Regular = textStyle(17, 400, 24
        ),
        Title3_Medium = textStyle(17, 500, 24,
            fontFamily = R.font.medium
        ),
        Title3_Semibold = textStyle(17, 600, 24,
            fontFamily = R.font.semibold
        ),
        Headline_Regular = textStyle( 16 , 400,  20,
            -0.32
        ),
        Headline_Medium = textStyle(16, 500, 20,
            -0.32, R.font.medium
        ),
        Text_Regular = textStyle(15, 400, 20
        ),
        Text_Medium = textStyle(15, 400, 20,
            fontFamily = R.font.medium
        ),
        Caption_Regular = textStyle(14, 400, 20
        ),
        Caption_Semibold = textStyle(14, 600, 20,
            fontFamily = R.font.semibold
        ),
        Caption2_Regular = textStyle(12, 400, 16
        ),
        Caption2_Bold = textStyle(12, 700, 20,
            fontFamily = R.font.bold
        )
    )
}