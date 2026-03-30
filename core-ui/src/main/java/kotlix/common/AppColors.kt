package kotlix.common

import androidx.compose.ui.graphics.Color


object AppColors {

    // 🌙 Neutral Dark Base (less blue, more graphite)
    val BgPrimary = Color(0xFF0E1014)     // deeper neutral
    val BgSurface = Color(0xFF171A21)     // subtle elevation
    val BgElevated = Color(0xFF1F2430)    // cards / panels

    // 💻 Code blocks (clean + subtle)
    val BgCode = Color(0xFF0F141B)
    val BgCodeHeader = Color(0xFF181E28)
    val CodeBorder = Color(0xFF2C3444)

    // 📝 Text tones (balanced contrast)
    val TextPrimary = Color(0xFFE8ECF3)
    val TextLight = Color(0xFFB4BDD0)
    val TextMuted = Color(0xFF7F8AA3)
    val TextCode = Color(0xFFD6DEEB)

    // 🎨 Accent system (new vibe — less neon, more premium)
    fun operatorAccentColor(index: Int): Color {
        val colors = listOf(

            Color(0xFF8B8CFF), // indigo
            Color(0xFF22C1A1), // teal
            Color(0xFFFF8A80), // coral
            Color(0xFF64B5F6), // blue
            Color(0xFFBA68C8), // purple
            Color(0xFF81C784), // green
            Color(0xFFFFC857), // yellow
            Color(0xFFA1887F), // warm grey
            Color(0xFF4DD0E1), // cyan
            Color(0xFFD4A5FF)  // soft violet
        )

        return colors[index % colors.size]
    }
}