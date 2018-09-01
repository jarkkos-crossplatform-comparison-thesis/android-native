package fi.jara.thesis.thesisnative

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class ViewNavigator {
    var activity: AppCompatActivity? = null

    fun gotoSelectTestView() {
        activity?.supportFragmentManager?.apply {
            popBackStack(BACKSTACK_ROOT, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            beginTransaction()
                    .replace(R.id.app_container, SelectTestFragment())
                    .addToBackStack(BACKSTACK_ROOT)
                    .commit()
        }
    }

    fun startTest(test: TestInfo) {
        activity?.let {
            it.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.app_container, test.fragmentCreator())
                    .addToBackStack(null)
                    .commit()
        }
    }

    companion object {
        private const val BACKSTACK_ROOT = "backstack_root"
    }
}