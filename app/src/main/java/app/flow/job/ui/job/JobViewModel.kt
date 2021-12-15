package app.flow.job.ui.job

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import app.flow.job.data.api.result.ApiResult
import app.flow.job.data.model.JobResponse
import app.flow.job.data.repository.JobRepository
import kotlinx.coroutines.Dispatchers

class JobViewModel(jobRepository: JobRepository) : ViewModel() {

    private val _jobs = jobRepository
        .getAllJob()

    val jobs: LiveData<ApiResult<JobResponse>>
        get() = _jobs.asLiveData(context = Dispatchers.IO)
}