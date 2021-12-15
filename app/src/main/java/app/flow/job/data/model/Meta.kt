package app.flow.job.data.model

import com.google.gson.annotations.SerializedName


data class Meta(

    @SerializedName("current_page") var currentPage: Int? = null,
    @SerializedName("from") var from: Int? = null,
    @SerializedName("path") var path: String? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("to") var to: Int? = null,
    @SerializedName("terms") var terms: String? = null,
    @SerializedName("info") var info: String? = null

)