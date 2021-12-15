package app.flow.job.data.model

import com.google.gson.annotations.SerializedName


data class JobResponse(

    @SerializedName("data") var data: List<JobModel> = arrayListOf(),
    @SerializedName("links") var links: Links? = Links(),
    @SerializedName("meta") var meta: Meta? = Meta()

)