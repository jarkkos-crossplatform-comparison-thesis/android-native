package fi.jara.thesis.thesisnative

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.camera.CameraFragment
import fi.jara.thesis.thesisnative.listitems.ListItemsFragment
import kotlinx.android.synthetic.main.select_test_fragment.*

class SelectTestFragment: Fragment() {
    lateinit var testItemsAdapter: TestInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testItemsAdapter = TestInfoAdapter(requireContext(), createTests())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.select_test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        test_list.adapter = testItemsAdapter
    }

    private fun createTests(): List<TestInfo> {
        return listOf(
                TestInfo(R.string.test_camera_name, R.string.test_camera_name) { CameraFragment() },
                TestInfo(R.string.test_local_list_name, R.string.test_local_list_description) { ListItemsFragment() },
                TestInfo(R.string.test_web_list_name, R.string.test_web_list_description) { ListItemsFragment() }
        )
    }
}

data class TestInfo(val nameRes: Int, val descriptionRes: Int, val fragmentCreator: () -> Fragment)

class TestInfoAdapter(context: Context, tests: List<TestInfo>): ArrayAdapter<TestInfo>(context, 0, tests) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val container = convertView ?: LayoutInflater.from(context).inflate(R.layout.test_list_item, parent, false)
        val test = getItem(position)!!

        container.findViewById<TextView>(R.id.test_title).setText(test.nameRes)
        container.findViewById<TextView>(R.id.test_description).setText(test.descriptionRes)

        return container
    }
}