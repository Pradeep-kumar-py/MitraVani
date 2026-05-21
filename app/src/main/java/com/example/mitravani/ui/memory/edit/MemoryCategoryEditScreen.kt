package com.example.mitravani.ui.memory.edit


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mitravani.R
import com.example.mitravani.navigation.LocalNavigator
import com.example.mitravani.ui.components.IconButtonLocal

@Composable
fun MemoryCategoryEditScreen() {
    val navigator = LocalNavigator.current
    var showModal by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121A1A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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

                Text(
                    text = "Add",
                    color = Color.White,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.width(20.dp))

            }

            Spacer(Modifier.height(16.dp))

            CategorySelectorDropDown(onClick = {showModal=true})

            Spacer(Modifier.height(16.dp))

            CategorySelectorDropDown(onClick = {showModal=true})

            Spacer(Modifier.height(36.dp))

            MemoryDescriptionSection()

            Spacer(Modifier.weight(1f))

            SaveButton()

        }

    }
    if(showModal){

        CategoryModal(

            onDismiss = {

                showModal = false

            }

        )

    }
}

@Composable
fun CategorySelectorDropDown(onClick: ()-> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {onClick() }
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

        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f).padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    "Category",
                    fontSize = 11.sp,
                    color = Color.White.copy(.6f)
                )
                Text(
                    "Background",
                    color = Color.White
                )
            }

            IconButtonLocal(
                onClick = { onClick()},
                icon = R.drawable.ic_arrow_forward,
                iconSize = 20.dp,
                boxSize = 30.dp
            )

        }
    }
}

@Composable
fun AboutSelectorDropDown() {
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

    }


}


@Composable
fun MemoryDescriptionSection() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Describe the memory",
            fontSize = 16.sp,
            color = Color.White
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = "For better results, always use names and pronouns",
            color = Color.White.copy(.8f)
        )
        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .clickable {  }
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.2f),
                    RoundedCornerShape(30.dp)
                ),
            contentAlignment = Alignment.TopStart
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .blur(20.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )


            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text("Pradeep doesn't like fruits", color = Color.White.copy(0.8f))
                },
//                textStyle = LocalTextStyle.current.copy(
//
//                    fontSize = 18.sp
//
//                ),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                maxLines = Int.MAX_VALUE
            )

        }
    }
}

@Composable
fun SaveButton() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth(.9f)
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
            "Save",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 14.dp)
        )
    }
}

@Composable
fun CategoryModal(
    onDismiss: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
    ) {

        Box(
            modifier = Modifier.fillMaxSize().background(Color(0xFF121A1A)).padding(10.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .border(
                            1.dp,
                            Color.White.copy(alpha = 0.2f),
                            RoundedCornerShape(30.dp)
                        ),

                ) {

                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .blur(20.dp)
                            .background(Color.White.copy(alpha = 0.08f))
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Category",
                            color = Color.White,
                            fontSize = 16.sp
                        )

                        Spacer(Modifier.height(30.dp))

                        ModalItem("Opinions")
                        ModalItem("Personality")
                        ModalItem("Other", selected = true)
                        ModalItem("Pinned Replika facts")
                        ModalItem("Pinned User facts")
                    }
                }

                Spacer(Modifier.height(20.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),

                    shape = RoundedCornerShape(35.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {

                    Text(
                        "Done",
                        color = Color.Black,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}



@Composable
fun ModalItem(
    text: String,
    selected: Boolean = false
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(
                if (selected)
                    Color.White.copy(alpha = 0.12f)
                else
                    Color.Transparent
            )
            .clickable { }
            .padding(vertical = 24.dp),

        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            color = if (selected)
                Color.White
            else
                Color.White.copy(alpha = 0.45f),

            fontSize = 20.sp
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MemoryCategoryEditScreenPreview() {
    MemoryCategoryEditScreen()
//    CategoryModal(
//
//        onDismiss = {
//
//
//
//        }
//
//    )
}