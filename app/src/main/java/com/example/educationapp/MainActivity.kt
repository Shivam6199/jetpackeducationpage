package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.EducationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    val genres = listOf("Brainstorm", "Books", "Videos", "Others")

    EducationAppTheme {
        Scaffold {
            Column(

                modifier = Modifier
                    .background(Color.White)
                    .padding(it)
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 25.dp),
                    text = buildAnnotatedString {
                        append("Choose What \n")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                        {
                            append("to learn today?")
                        }
                    })
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(bottom = 25.dp)
                ) {
                    items(genres) { genre ->
                        Genre(genre)
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clip(RoundedCornerShape(10))
                        .background(colorResource(id = R.color.main))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 30.dp)
                                .padding(start = 20.dp)
                        ) {
                            Text(
                                text = "Vocabulary",
                                color = Color.White,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(
                                text = "Listen to 20 new words",
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.size(40.dp))

                            Button(
                                modifier = Modifier
                                    .size(height = 60.dp, width = 120.dp)
                                    .clip(RoundedCornerShape(20)),
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.White
                                )
                            ) {
                                Text(text = "Start", color = Color.Black, fontSize = 18.sp)
                                Spacer(modifier = Modifier.size(10.dp))
                                Box(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape)
                                        .background(Color.Black),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Icon(
                                        modifier = Modifier.padding(5.dp),
                                        imageVector = Icons.Filled.PlayArrow,
                                        contentDescription = "Arrow Icon  or Play icon",
                                        tint = Color.White

                                    )
                                }
                            }
                        }
                        Image(
                            painterResource(id = R.drawable.brainy),
                            contentDescription = "avtar image?",
                            modifier = Modifier.weight(1f, fill = false)
                        )
                    }
                }
                Text(
                    text = "Recommended",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(vertical = 30.dp)

                )
                    LazyColumn(
                        modifier = Modifier.padding(end = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        items(3) {
                            Recommended()
                        }
                    }
                }
            }
        }
    }


@Composable
fun Genre(text: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .background(if (isSelected) Color.Black else Color.LightGray)
            .clickable {
                isSelected = !isSelected
            },
        contentAlignment = Alignment.Center
    )
    {
        Text(
            modifier = Modifier.padding(10.dp),
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Recommended() {

    var isSelected by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20))
            .background(colorResource(id = R.color.seal)),
        contentAlignment = Alignment.Center
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorResource(id = R.color.orange)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(10.dp)

                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Chatting",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "5 minutes",
                    color = Color.DarkGray,
                    fontSize = 18.sp
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "icon",
                    tint = if (isSelected) Color.Yellow else Color.LightGray,
                    modifier = Modifier.size(32.dp)
                )
            }


        }


    }

}
