package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.data.DataSource
import com.example.coursesapp.model.Course
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                color = MaterialTheme.colorScheme.background
            ) {
                CoursesAppTheme {
                    CoursesGrid(DataSource.courses)
                }
            }
        }
    }
}


@Composable
fun CoursesGrid(coursesList: List<Course>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(coursesList) { course ->
            CoursesCard(
                course = course,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))

        }
    }
}


@Composable
fun CoursesCard(course: Course, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Card(modifier = modifier) {
            Row {
                Image(
                    painterResource(course.coursePhotoImageResourceId),
                    contentDescription = stringResource(course.courseNameStringResourceId),
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium))
                ) {
                    Text(
                        text = LocalContext.current.getString(course.courseNameStringResourceId),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
                    )
                    Row {
                        Image(
                            painterResource(R.drawable.grain),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = course.numberOfCourses.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                        )
                    }
                }
            }
        }
    }
}

/*
@Preview
@Composable
private fun CoursesCardPreview() {
    CoursesCard(Course(R.string.film, 123, R.drawable.film))
}
*/


@Preview
@Composable
private fun CoursesGridPreview() {
    CoursesGrid(DataSource.courses)
}
