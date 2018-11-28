package fi.jara.thesis.thesisnative.listitems.data.filesystem

import android.content.Context
import fi.jara.thesis.thesisnative.listitems.data.ImageLoader
import kotlinx.coroutines.CoroutineScope
import java.io.InputStream

class AssetsImageLoader(private val context: Context): ImageLoader() {
    override fun getImageInputStream(uri: String): InputStream {
        return context.assets.open(uri)
    }
}