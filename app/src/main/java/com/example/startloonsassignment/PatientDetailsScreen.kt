package com.example.startloonsassignment

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientDetails() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "View Patient",
                        color = Color(0xFF012E57),
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            ShowDetails(it)
        }
    )
}

@Composable
fun ShowDetails(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Divider(
            color = Color(0xFF7D7D7D), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "S.Meena, F/23",
                    fontSize = 20.sp,
                    color = Color(0xFF012E57)
                )
                Text(
                    text = "Patient ID:87 20200727153457",
                    fontSize = 16.sp,
                    color = Color(0xFF012E57)
                )
            }

            Icon(
                modifier = Modifier.size(40.dp, 40.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile Image",
                tint = Color(0xFF012E57)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF002647)
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Goal Reached",
                    fontSize = 18.sp,
                    color = Color.White
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box {
                        Canvas(
                            modifier = Modifier
                                .size(width = 240.dp, height = 150.dp)
                                .padding(20.dp)
                        ) {
                            val progress = 0.4f // 40% progress
                            val sweepAngle = progress * 180 // convert progress to degrees

                            drawArc(
                                color = Color.White,
                                -180f,
                                180f,
                                useCenter = false,
                                size = Size(size.width, size.height * 2),
                                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
                            )

                            drawArc(
                                color = Color(0xFFFCB000),
                                -180f,
                                sweepAngle = sweepAngle,
                                useCenter = false,
                                size = Size(size.width, size.height * 2),
                                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }
                        Text(
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .padding(top = 16.dp),
                            text = "40 %",
                            color = Color.White,
                            fontSize = 28.sp
                        )
                    }
                    Column(
                        modifier = Modifier.padding(end = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(4.dp)
                        ) {
                            Text(text = "EMG", Modifier.align(Alignment.TopCenter))
                            Image(
                                painter = painterResource(R.drawable.increase),
                                contentDescription = "increase",
                                modifier = Modifier
                                    .requiredSize(40.dp)
                                    .align(Alignment.BottomCenter)
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(4.dp)
                        ) {
                            Text(text = "ROM", Modifier.align(Alignment.TopCenter))
                            Image(
                                painter = painterResource(R.drawable.decrease),
                                contentDescription = "increase",
                                modifier = Modifier
                                    .requiredSize(40.dp)
                                    .align(Alignment.BottomCenter)
                            )
                        }
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1.5f)
            ) {
                Text(
                    text = "Phone no.",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 2.dp),
                    color = Color(0xFFAEACAC)
                )
                Text(
                    text = "Mail ID", fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 2.dp),
                    color = Color(0xFFAEACAC)
                )
                Text(
                    text = "Affected side",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 2.dp),
                    color = Color(0xFFAEACAC)
                )
                Text(
                    text = "Condition",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 2.dp),
                    color = Color(0xFFAEACAC)
                )
                Text(
                    text = "Speciality",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 2.dp),
                    color = Color(0xFFAEACAC)
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .weight(4f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.Call,
                        contentDescription = "Contact",
                        tint = Color(0xFF002647)
                    )
                    Text(text = "8022334455", fontSize = 16.sp ,
                        color = Color(0xFF002647)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Mail",
                        tint = Color(0xFF002647)
                    )
                    Text(text = "meenarabinsachin2@gmail.com", fontSize = 16.sp,
                        color = Color(0xFF002647))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Contact",
                        tint = Color(0xFFDf0100)
                    )
                    Text(text = "Billateral", fontSize = 16.sp,
                        color = Color(0xFF002647)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.Medication,
                        contentDescription = "Contact",
                        tint = Color(0xFF002647)
                    )
                    Text(text = "Ortho", fontSize = 16.sp,
                        color = Color(0xFF002647))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.LocalHospital,
                        contentDescription = "Contact",
                        tint = Color(0xFF002647)
                    )
                    Text(text = "Osteoarthritis", fontSize = 16.sp,
                        color = Color(0xFF002647))
                }
            }
        }

        Divider(
            color = Color(0xFF7D7D7D), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.Receipt,
                        contentDescription = "Receipt",
                        tint = Color(0xFF002647)
                    )
                    Text(text = "Medical History", fontSize = 16.sp,
                        color = Color(0xFF002647),
                        fontWeight = FontWeight.SemiBold)
                }
            }

            Column(
                modifier = Modifier
                    .weight(4f)
            ) {
                Text("Hypertension, DM, Hypothyrodism")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color(0xFF7D7D7D), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PatientDetailsPreview() {
    PatientDetails()
}
