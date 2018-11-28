package fi.jara.thesis.thesisnative.listitems.data.filesystem

import android.content.Context
import fi.jara.thesis.thesisnative.listitems.data.ListDataLoader
import java.io.InputStream

class AssetsListDataLoader(private val context: Context): ListDataLoader() {
    override fun getItemsInputStream(): InputStream {
        return context.assets.open("listItems.json")
    }
}