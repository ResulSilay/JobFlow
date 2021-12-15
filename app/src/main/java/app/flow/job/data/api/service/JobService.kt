package app.flow.job.data.api.service

import app.flow.job.data.api.ApiConst.API_V1
import app.flow.job.data.model.JobResponse
import retrofit2.Response
import retrofit2.http.GET

interface JobService {

    @GET("${API_V1}/job-board-api")
    suspend fun getPostAll(): Response<JobResponse>
}