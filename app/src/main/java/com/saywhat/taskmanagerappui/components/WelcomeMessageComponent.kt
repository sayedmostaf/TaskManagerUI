package com.saywhat.taskmanagerappui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saywhat.taskmanagerappui.R
import com.saywhat.taskmanagerappui.ui.theme.LightGray

@Composable
fun WelcomeMessageComponent() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Hi Sayed",
            fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
            fontSize = 22.sp
        )
        Text(
            text = "8 tasks for today Monday",
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            fontSize = 18.sp,
            color = LightGray
        )
    }
}