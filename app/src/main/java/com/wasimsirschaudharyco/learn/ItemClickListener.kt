package com.wasimsirschaudharyco.learn

import com.wasimsirschaudharyco.model.VideoMaterial

interface TopicClickListener {
    fun onTopicSelected(subTopicItems: List<VideoMaterial>)
}