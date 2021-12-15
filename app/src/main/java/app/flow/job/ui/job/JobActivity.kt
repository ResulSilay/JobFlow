package app.flow.job.ui.job

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.flow.job.data.api.ApiClient
import app.flow.job.data.api.result.ApiStatus.*
import app.flow.job.data.model.JobModel
import app.flow.job.data.repository.JobRepository
import app.flow.job.databinding.ActivityJobBinding
import app.flow.job.ui.job.adapter.JobAdapter

class JobActivity : AppCompatActivity(), JobAdapter.JobItemClickListener {

    private lateinit var binding: ActivityJobBinding
    private lateinit var viewModel: JobViewModel
    private lateinit var jobRepository: JobRepository
    private lateinit var apiClient: ApiClient
    private lateinit var jobAdapter: JobAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiClient = ApiClient.instance()
        jobRepository = JobRepository.instance(apiClient)
        viewModel = ViewModelProvider(
            this,
            JobViewModelFactory(jobRepository)
        ).get(JobViewModel::class.java)

        initJobRecycler()
        getJobs()
    }

    private fun initJobRecycler() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        jobAdapter = JobAdapter(this)
        binding.jobRV.layoutManager = linearLayoutManager
        binding.jobRV.adapter = jobAdapter
    }

    override fun onJobItemClick(jobModel: JobModel) {
        Toast.makeText(this, jobModel.title, Toast.LENGTH_LONG).show()
    }

    private fun getJobs() {
        viewModel.jobs.observe(this, { result ->
            when (result.status) {
                SUCCESS -> {
                    result.data?.data?.let { jobAdapter.set(it) }
                }
                FAILURE -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                }
                LOADING -> {
                    binding.jobRV.visibility = View.GONE
                    binding.loadingCLP.show()
                }
                COMPLETED -> {
                    binding.loadingCLP.hide()
                    binding.jobRV.visibility = View.VISIBLE
                }
            }
        })
    }
}