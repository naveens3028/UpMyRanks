package com.wasimsirschaudharyco.adapter

import com.wasimsirschaudharyco.model.MOCKTEST
import com.wasimsirschaudharyco.model.onBoarding.AttemptedTest

interface TestClickListener {
    fun onTestClicked(isClicked : Boolean,mockTest: MOCKTEST)
    fun onResultClicked(id : String)
    fun onResultClicked(attempt :Int, studentId : String, testPaperId: String)
    fun onReviewClicked(attempt : AttemptedTest)
}