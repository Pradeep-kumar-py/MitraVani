package com.example.mitravani.ui.memory

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.mitravani.R
import com.example.mitravani.ui.components.IconButtonLocal

@Composable
fun MemoryScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121A1A)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "MitraVani",
                            fontSize = 26.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.5.sp,
                        )

                        IconButton(
                            onClick = { },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = null,
                                tint = Color(0xFFCCF5E1)
                            )
                        }
                    }

                    Text(
                        "Female",
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        letterSpacing = 0.5.sp,
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        "Hello Pradeep kumar",
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        letterSpacing = 0.5.sp,
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Relationship",
                        fontSize = 26.sp,
                        color = Color.White,
                        letterSpacing = 0.5.sp,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        RelationshipButton("Friend", onClick = {})
                        RelationshipButton("Friend", onClick = {})
                        RelationshipButton("Friend", onClick = {})
                        RelationshipButton("Friend", onClick = {})
                        RelationshipButton("Friend", onClick = {})
                        RelationshipButton("Friend", onClick = {})
                        RelationshipButton("Friend", onClick = {})
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Memories",
                            fontSize = 26.sp,
                            color = Color.White,
                            letterSpacing = 0.5.sp,
                        )

                        IconButtonLocal(
                            onClick = { },
                            icon = R.drawable.ic_arrow_forward,
                            iconSize = 24.dp,
                            boxSize = 36.dp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    NoMemoriesCard(onClick = {})
                }
                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Voices",
                            fontSize = 26.sp,
                            color = Color.White,
                            letterSpacing = 0.5.sp,
                        )

                        IconButtonLocal(
                            onClick = { },
                            icon = R.drawable.ic_arrow_forward,
                            iconSize = 24.dp,
                            boxSize = 36.dp
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    PlayableVoiceCard(onClick = {})
                }

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Backstory",
                            fontSize = 26.sp,
                            color = Color.White,
                            letterSpacing = 0.5.sp,
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    BackStoryCard(onClick = {})

                }

                Spacer(modifier = Modifier.height(30.dp))
            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 0.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonLocal(
                    onClick = { },
                    icon = R.drawable.ic_arrow_back,
                    iconSize = 24.dp,
                    boxSize = 36.dp
                )
                IconButtonLocal(
                    onClick = { },
                    icon = R.drawable.ic_close,
                    iconSize = 24.dp,
                    boxSize = 36.dp
                )
            }
        }
    }
}


@Composable
fun RelationshipButton(
    name: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .clickable { onClick() }
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center
    ) {

        // 🔹 Background layer (blur + tint)
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        // 🔹 Foreground text (NOT blurred)
        Text(
            text = name,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
        )
    }
}


@Composable
fun NoMemoriesCard(
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(14))
            .fillMaxWidth()
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(14)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nothing here yet",
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = "Getting to know each other is\n" + "exciting. Mitravani will always\n" + "remember what's important to you.",
                color = Color.White.copy(0.7f),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            NoMemoriesCardAddButton(onClick = { onClick() })

        }
    }
}


@Composable
fun NoMemoriesCardAddButton(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .border(
                width = 1.dp,
                color = Color.White.copy(0.2f),
                shape = RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(0.08f))
        )

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = "add button",
                tint = Color.White
            )
            Text(
                text = "Add",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 6.dp)
            )
        }
    }
}


@Composable
fun PlayableVoiceCard(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .fillMaxWidth()
            .clickable { onClick() }
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center
    ) {

        // 🔹 Background layer (blur + tint)
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtonLocal(
                onClick = { },
                icon = R.drawable.ic_play_arrow,
                iconSize = 36.dp,
                boxSize = 48.dp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Calm",
                fontSize = 24.sp,
                color = Color.White
            )
        }

    }
}


@Composable
fun BackStoryCard(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(14))
            .fillMaxWidth()
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(14)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nothing here yet",
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = "Shape Mitravani's personality by\n" + "adding backstory to your\n" + "conversation.",
                color = Color.White.copy(0.7f),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            NoMemoriesCardAddButton(onClick = { onClick() })

        }
    }
}


@Preview(showBackground = true)
@Composable
fun MemoryScreenPreview() {
    MemoryScreen()
}