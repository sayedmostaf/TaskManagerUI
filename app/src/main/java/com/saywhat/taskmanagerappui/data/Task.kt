package com.saywhat.taskmanagerappui.data


data class Task(
    val id: Int,
    val title: String,
    val body: String? = null,
    val startTime: String,
    val endTime: String
)

val taskList = listOf(
    Task(
        1,
        "Review code",
        "Review pull requests and provide feedback",
        "09:00",
        "10:00"
    ), Task(
        2,
        "Attend daily stand-up meeting",
        "Discuss current progress and any blockers",
        "10:15",
        "10:30"
    ), Task(
        3,
        "Develop new feature",
        "Write code for implementing a new feature",
        "10:30",
        "12:30"
    ), Task(
        4,
        "Lunch break",
        "Take a break and have lunch",
        "12:30",
        "13:30"
    ), Task(
        5,
        "Code refactoring",
        "Refactor existing code for better readability and performance",
        "13:30",
        "15:00"
    ), Task(
        6,
        "Testing",
        "Write and execute test cases for the implemented feature",
        "15:00",
        "16:30"
    ), Task(
        7,
        "Documentation",
        "Update project documentation",
        "16:30",
        "17:00"
    ), Task(
        8,
        "Code review",
        "Review code submitted by team members",
        "17:00",
        "18:00"
    ), Task(
        9,
        "Learning time",
        "Spend time learning new technologies or improving skills",
        "18:00",
        "19:00"
    ), Task(
        10,
        "Wrap-up",
        "Prepare for the next day, update task board, and plan",
        "19:00",
        "19:30"
    )
)