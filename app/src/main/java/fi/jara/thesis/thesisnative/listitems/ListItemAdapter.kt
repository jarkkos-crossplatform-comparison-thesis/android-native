package fi.jara.thesis.thesisnative.listitems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.listitems.data.ImageLoader
import fi.jara.thesis.thesisnative.listitems.data.ListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class ListItemAdapter(
        private var items: List<ListItem>,
        private val imageLoader: ImageLoader,
        private val coroutineScope: CoroutineScope) : RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(items[position], imageLoader, coroutineScope)
    }
}

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemImage = itemView.findViewById<ImageView>(R.id.item_image)
    private val itemDescription = itemView.findViewById<TextView>(R.id.item_description)

    private var imageLoadingJob: Job? = null

    fun bind(item: ListItem, imageLoader: ImageLoader, coroutineScope: CoroutineScope) {
        itemDescription.text = item.description
        itemImage.setImageBitmap(null)

        imageLoadingJob?.cancel()
        imageLoadingJob = coroutineScope.launch {
            itemImage.setImageBitmap(imageLoader.loadImage(item.imageSrc))
        }
    }
}