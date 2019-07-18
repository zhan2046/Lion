package com.ruzhan.jsonfile.model

class Video {

    var id: String
    var title: String
    var image: String
    var playCount: String
    var playNumber: Int = 0
    var playNumberDesc: String
    var playWebUrl: String

    var videoUrl: String = ""

    constructor(id: String, title: String, image: String, playCount: String, playNumber: Int,
                playNumberDesc: String, playWebUrl: String) {
        this.id = id
        this.title = title
        this.image = image
        this.playCount = playCount
        this.playNumber = playNumber
        this.playNumberDesc = playNumberDesc
        this.playWebUrl = playWebUrl
    }

    constructor(id: String, title: String, image: String, playCount: String, playNumber: Int,
                playNumberDesc: String, playWebUrl: String, videoUrl: String) {
        this.id = id
        this.title = title
        this.image = image
        this.playCount = playCount
        this.playNumber = playNumber
        this.playNumberDesc = playNumberDesc
        this.playWebUrl = playWebUrl
        this.videoUrl = videoUrl
    }
}
