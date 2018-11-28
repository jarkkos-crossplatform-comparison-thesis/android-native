package fi.jara.thesis.thesisnative.listitems.data.network

import fi.jara.thesis.thesisnative.listitems.data.ImageLoader
import kotlinx.coroutines.CoroutineScope
import java.io.InputStream
import java.net.URL

class NetworkImageLoader : ImageLoader() {
    override fun getImageInputStream(uri: String): InputStream {
        return URL(uri).openStream()
    }
}