package shibin.kotlix.models

import androidx.compose.ui.graphics.Color

data class LearningModule(
    val id: String,
    val title: String,
    val description: String,
    val accentColor: Color,
)