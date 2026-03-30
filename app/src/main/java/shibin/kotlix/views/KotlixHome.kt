package shibin.kotlix.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlix.common.AppColors
import shibin.kotlix.core.ModuleRegistry

@Composable
fun KotlixHome(onModuleClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.BgPrimary)
            .padding(20.dp)
    ) {

        // 🔥 Header
        Text(
            text = "Kotlix 🚀", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = "Learn Kotlin visually", color = AppColors.TextMuted, fontSize = 14.sp
        )

        Spacer(Modifier.height(28.dp))


        // 🔥 Core Modules
        SectionTitle("CORE CONCEPTS")

        Spacer(Modifier.height(12.dp))

        ModuleGrid(onModuleClick = { moduleId ->
            onModuleClick(moduleId)
        })
    }
}


@Composable
fun SectionTitle(text: String) {
    Text(
        text = text, color = Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Bold
    )
}

@Composable
fun ModuleGrid(onModuleClick: (String) -> Unit) {


    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {

        ModuleRegistry.modules.chunked(2).forEach { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                rowItems.forEach { module ->

                    ModuleCard(
                        modifier = Modifier
                            .weight(1f)
                            .height(110.dp),
                        title = module.title,
                        desc = module.description,
                        accent = module.accentColor,
                        isFeatured = module.id == "flow", // still highlight subtly
                        onClick = { onModuleClick(module.id) })
                }

                if (rowItems.size == 1) Spacer(Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun ModuleCard(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    accent: Color,
    isFeatured: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(AppColors.BgSurface)
            .border(
                1.dp,
                if (isFeatured) accent else accent.copy(alpha = 0.25f),
                RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(14.dp)) {

        // 🔥 subtle highlight (not size)
        if (isFeatured) {
            Text(
                text = "FLOW", fontSize = 10.sp, color = accent, fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
        }

        Text(
            text = title, fontSize = 17.sp, fontWeight = FontWeight.Bold, color = accent
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = desc, fontSize = 12.sp, color = AppColors.TextMuted, maxLines = 2
        )
    }
}