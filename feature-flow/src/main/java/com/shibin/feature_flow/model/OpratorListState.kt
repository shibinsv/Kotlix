package com.shibin.feature_flow.model

import com.shibin.feature_flow.data.FlowOperator

// ui/list/OperatorListState.kt
data class OperatorListState(
    val operators: List<FlowOperator> = emptyList(),
    val isLoading: Boolean = false
)

// ui/detail/OperatorDetailState.kt
data class OperatorDetailState(
    val operator: FlowOperator? = null,
    val demoInput: String = "",
    val demoOutput: List<String> = emptyList(),
    val isDemoRunning: Boolean = false
)