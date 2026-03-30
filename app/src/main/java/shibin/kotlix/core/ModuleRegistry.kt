package shibin.kotlix.core

import kotlix.common.AppColors
import shibin.kotlix.models.LearningModule

object ModuleRegistry {

    val modules = listOf(
        LearningModule("flow", "Flow", "Streams & operators", AppColors.operatorAccentColor(0)),
        LearningModule("coroutines", "Coroutines", "Async basics", AppColors.operatorAccentColor(1)),
        LearningModule("compose", "Compose", "Modern UI", AppColors.operatorAccentColor(2)),
        LearningModule("state", "State", "State management", AppColors.operatorAccentColor(3))
    )

    fun getById(id: String): LearningModule? {
        return modules.find { it.id == id }
    }

}