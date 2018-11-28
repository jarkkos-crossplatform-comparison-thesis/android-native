package fi.jara.thesis.thesisnative.listitems.data.network

import fi.jara.thesis.thesisnative.listitems.data.ListDataLoader
import java.io.InputStream
import java.net.URL

class NetworkDataLoader: ListDataLoader() {
    override fun getItemsInputStream(): InputStream {
        return URL("192.168.1.42/androidnative/listItems.json").openStream()
    }
}