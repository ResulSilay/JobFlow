package app.flow.job.data.repository

import app.flow.job.data.api.ApiClient
import app.flow.job.data.api.result.ApiResult
import app.flow.job.data.api.service.JobService
import kotlinx.coroutines.flow.flow

class JobRepository(private val apiClient: ApiClient) {

    fun getAllJob() = flow {
        emit(ApiResult.Loading(true))
        val response = apiClient.client()?.create(JobService::class.java)?.getPostAll()
        response?.let {
            if (response.isSuccessful) {
                emit(
                    ApiResult.Success(
                        _code = response.code(),
                        _data = response.body()
                    )
                )
            } else {
                emit(
                    ApiResult.Failure(
                        _code = response.code(),
                        _message = response.errorBody()?.toString()
                    )
                )
            }
        }
        emit(ApiResult.Completed(_code = response?.code(), _message = response?.message()))
    }

    companion object {
        private var instance: JobRepository? = null

        fun instance(apiClient: ApiClient): JobRepository {
            if (instance == null)
                return JobRepository(apiClient)

            return instance as JobRepository
        }
    }
}