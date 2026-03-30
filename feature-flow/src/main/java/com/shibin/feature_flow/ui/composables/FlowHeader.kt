package com.shibin.feature_flow.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlix.common.AppColors.BgPrimary
import kotlix.common.AppColors.TextLight

@Composable
fun FlowHeader(
    title: String,
    subtitle: String,
    accent: Color,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(accent.copy(alpha = 0.18f), BgPrimary)
                )
            )
            .padding(start = 20.dp, end = 20.dp, top = 56.dp, bottom = 24.dp)
    ) {

        // 🔙 Back button (same style as DetailHero)
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.08f))
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }

        Column(modifier = Modifier.padding(top = 60.dp)) {

            Text(
                text = "MODULE",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = accent
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = title,
                fontSize = 26.sp,
                fontWeight = FontWeight.Black,
                color = accent
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = TextLight
            )
        }
    }
}