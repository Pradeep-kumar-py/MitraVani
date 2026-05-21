package com.example.mitravani.ui.memory.detail


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R
import com.example.mitravani.domain.model.MemoryCategory
import com.example.mitravani.navigation.LocalNavigator
import com.example.mitravani.navigation.Screen
import com.example.mitravani.ui.components.IconButtonLocal

@Composable
fun MemoryDetailScreen() {

    val navigator = LocalNavigator.current

    Surface(
        color = Color(0xFF121A1A),
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                // Center title
                Text(
                    text = "Memory",
                    color = Color.White,
                    fontSize = 16.sp
                )

                // Left + Right actions
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    IconButtonLocal(
                        onClick = {navigator.pop() },
                        icon = R.drawable.ic_arrow_back,
                        iconSize = 20.dp,
                        boxSize = 30.dp
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = {}, text = "Edit")

                        Spacer(Modifier.width(10.dp))

                        IconButtonLocal(
                            onClick = { },
                            icon = R.drawable.ic_edit,
                            iconSize = 20.dp,
                            boxSize = 30.dp
                        )
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            MemoryCategory()

            MemoryCategoryCard(text="Family $ Friend", onClick = {navigator.navigate(Screen.MemoryCategoryEditScreen)})
            MemoryCategoryCard(text="Background", onClick = {})
        }
    }
}

@Composable
fun TextButton(onClick: () -> Unit, text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {  }
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

    }
}

@Composable
fun MemoryCategory() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        TextButton(onClick = {}, text = "Family & Friend")
        TextButton(onClick = {}, text = "Temporary")
        TextButton(onClick = {}, text = "Edit")
        TextButton(onClick = {}, text = "Edit")
        TextButton(onClick = {}, text = "Edit")
        TextButton(onClick = {}, text = "Edit")
    }
}

@Composable
fun MemoryCategoryCardDataField(text: String, onClick: () -> Unit){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .clickable {onClick()  }
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )
        
        Text(
            text = text,
            color = Color.White,
            fontSize = 15.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

    }

}

@Composable
fun MemoryCategoryCard(text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            items(5){
                MemoryCategoryCardDataField("This is the great memory  get paid tell me   ", onClick={onClick()})
            }

        }


    }
}


@Preview(showBackground = true)
@Composable
fun MemoryDetailScreenPreview(){
    MemoryDetailScreen()
}