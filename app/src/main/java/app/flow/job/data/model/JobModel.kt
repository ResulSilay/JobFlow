package app.flow.job.data.model

import com.google.gson.annotations.SerializedName


data class JobModel(

    @SerializedName("slug") var slug: String? = null,
    @SerializedName("company_name") var companyName: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("remote") var remote: Boolean? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("tags") var tags: List<String> = arrayListOf(),
    @SerializedName("job_types") var jobTypes: List<String> = arrayListOf(),
    @SerializedName("location") var location: String? = null,
    @SerializedName("created_at") var createdAt: Int? = null

)