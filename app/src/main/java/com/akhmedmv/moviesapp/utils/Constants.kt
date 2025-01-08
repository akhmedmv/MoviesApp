package com.akhmedmv.moviesapp.utils

import android.util.TypedValue
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

class Constants {

    object Screens {
        const val SPLASH_SCREEN = "splash_screen"
        const val MAIN_SCREEN = "main_screen"
        const val DETAILS_SCREEN = "details_screen"
    }
}

@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier, fontSize: Float = 16f) {
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context) },
        update = { text ->
            text.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize)
            text.setTextColor(Color.Black.toArgb())
        }
    )
}
