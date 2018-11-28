package fi.jara.thesis.thesisnative.listitems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.listitems.data.ImageLoader
import fi.jara.thesis.thesisnative.listitems.data.ListDataLoader
import fi.jara.thesis.thesisnative.listitems.data.filesystem.AssetsImageLoader
import fi.jara.thesis.thesisnative.listitems.data.filesystem.AssetsListDataLoader
import fi.jara.thesis.thesisnative.listitems.data.network.NetworkDataLoader
import fi.jara.thesis.thesisnative.listitems.data.network.NetworkImageLoader
import kotlinx.android.synthetic.main.list_items_fragment.*
import kotlinx.coroutines.*
import java.io.IOException

class ListItemsFragment : Fragment() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var dataLoadingJob: Job? = null

    private lateinit var dataLoder: ListDataLoader
    private lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ListItemsFragmentArgs.fromBundle(arguments).useNetwork) {
            dataLoder = NetworkDataLoader()
            imageLoader = NetworkImageLoader()
        } else {

            dataLoder = AssetsListDataLoader(requireContext())
            imageLoader = AssetsImageLoader(requireContext())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_items_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        items_recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    override fun onStart() {
        super.onStart()

        items_recyclerview.visibility = View.GONE
        items_loading_indicator.visibility = View.VISIBLE
        dataLoadingJob = coroutineScope.launch {
            try {
                val data = dataLoder.loadItems()

                items_recyclerview.visibility = View.VISIBLE
                items_recyclerview.adapter = ListItemAdapter(data, imageLoader, coroutineScope)
            } catch (e: IOException) {
                Toast.makeText(requireContext(), resources.getString(R.string.error_loading_listitem_data, e.localizedMessage), Toast.LENGTH_LONG).show()
            }
            finally {
                items_loading_indicator.visibility = View.GONE
            }
        }
    }

    override fun onStop() {
        super.onStop()
        dataLoadingJob?.cancel()
    }
}