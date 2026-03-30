package com.shibin.feature_flow.data

import com.shibin.feature_flow.enums.DemoType

data class FlowOperator(
    val id: String,
    val name: String,
    val description: String,
    val impact: String,
    val codeSnippet: String,
    val demoType: DemoType,

    val explanationSteps: List<String>,
    val exampleInput: List<String> = emptyList(),
    val exampleOutput: List<String> = emptyList()
)