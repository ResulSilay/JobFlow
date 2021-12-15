package app.flow.job.ui.job

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.flow.job.data.repository.JobRepository

class JobViewModelFactory constructor(private val repository: JobRepository?) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(JobViewModel::class.java)) {
            this.repository?.let { JobViewModel(it) } as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}