package com.wasimsirschaudharyco.adapter

interface AnswerClickListener {
    fun onAnswerClicked(isClicked: Boolean, option: Char, position: Int)
}