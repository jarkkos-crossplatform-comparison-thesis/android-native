package fi.jara.thesis.thesisnative.listitems.data.network

import fi.jara.thesis.thesisnative.listitems.data.ListDataLoader
import java.io.InputStream
import java.net.URL

class NetworkDataLoader: ListDataLoader() {
    override fun getItemsInputStream(): InputStream {
        return URL("http://192.168.1.158/thesis/listItems.json").openStream()
    }
}