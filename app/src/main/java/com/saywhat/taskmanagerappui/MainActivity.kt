package com.saywhat.taskmanagerappui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.saywhat.taskmanagerappui.components.ProfileHeaderComponent
import com.saywhat.taskmanagerappui.components.TaskComponent
import com.saywhat.taskmanagerappui.components.WelcomeMessageComponent
import com.saywhat.taskmanagerappui.data.taskList
import com.saywhat.taskmanagerappui.ui.theme.TaskManagerAppUITheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedScreen by remember { mutableIntStateOf(1) }
            val screens = listOf("Calendar", "Home", "Notifications")
            TaskManagerAppUITheme {
                Scaffold(bottomBar = {
                    BottomNavigation(
                        modifier = Modifier.height(90.dp),
                        backgroundColor = Color.White,
                        elevation = 0.dp
                    ) {
                        screens.forEachIndexed { index, _ ->
                            val icon: ImageVector = when (index) {
                                0 -> Icons.Rounded.DateRange
                                1 -> Icons.Rounded.Home
                                2 -> Icons.Rounded.Email
                                else -> Icons.Rounded.Home
                            }
                            BottomNavigationItem(
                                selected = selectedScreen == index,
                                onClick = { selectedScreen = index },
                                icon = {
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(if (selectedScreen == index) Color.Black else Color.White)
                                            .padding(12.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = "Calendar",
                                            modifier = Modifier
                                                .padding(12.dp),
                                            tint = if (selectedScreen == index) Color.White else Color.Black
                                        )
                                    }
                                }
                            )
                        }
                    }
                }) {
                    LazyColumn(
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                    ) {
                        item {
                            ProfileHeaderComponent()
                        }
                        item {
                            Spacer(modifier = Modifier.height(30.dp))
                            WelcomeMessageComponent()
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                        items(taskList) { task ->
                            TaskComponent(task = task)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

