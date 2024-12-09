package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseNameStringResourceId: Int,
    val numberOfCourses: Int,
    @DrawableRes val coursePhotoImageResourceId: Int,
)
