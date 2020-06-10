package com.example.module_network.model.livechannel

class Live_Review :BaseLiveChannel() {

    lateinit var videos:List<Videos>

    inner class Videos {
        var videoUrl = ""
    }
}