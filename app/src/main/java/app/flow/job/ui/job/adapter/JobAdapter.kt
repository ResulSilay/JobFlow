package app.flow.job.ui.job.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.flow.job.data.model.JobModel
import app.flow.job.databinding.ItemJobBinding

class JobAdapter(private val listener: JobItemClickListener) :
    RecyclerView.Adapter<JobAdapter.ViewHolder>() {

    private var itemList: ArrayList<JobModel> = arrayListOf()

    fun set(itemList: List<JobModel>) {
        itemList.let {
            this.itemList.clear()
            this.itemList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun get(position: Int): JobModel {
        return itemList[position]
    }

    interface JobItemClickListener {
        fun onJobItemClick(jobModel: JobModel)
    }

    class ViewHolder(private val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: JobModel?, listener: JobItemClickListener) {
            if (item != null) {
                binding.titleTV.text = item.title
                binding.companyNameTV.text = item.companyName
                binding.createdDateTV.text = item.createdAt.toString()
                binding.locationTV.text = item.location.toString()
            }
            binding.root.setOnClickListener { item?.let { it1 -> listener.onJobItemClick(it1) } }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position], listener)
    }
}