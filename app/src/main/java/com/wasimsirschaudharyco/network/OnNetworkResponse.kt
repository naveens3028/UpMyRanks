package com.wasimsirschaudharyco.network

interface OnNetworkResponse {
    fun onNetworkResponse(responseCode:Int, response:String, tag:String)
}