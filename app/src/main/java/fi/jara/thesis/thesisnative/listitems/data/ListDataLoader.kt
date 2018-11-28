package fi.jara.thesis.thesisnative.listitems.data

import android.util.JsonReader
import kotlinx.coroutines.*
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.IllegalArgumentException

abstract class ListDataLoader {
    suspend fun loadItems(): List<ListItem> {
        return withContext(Dispatchers.IO) {
            val jsonReader = JsonReader(InputStreamReader(getItemsInputStream()))
            jsonReader.use { reader ->
                val listItems = mutableListOf<ListItem>()
                reader.beginArray()
                while (reader.hasNext()) {
                    listItems.add(readListItem(reader))
                }
                reader.endArray()
                listItems
            }
        }
    }

    private fun readListItem(jsonReader: JsonReader): ListItem {
        var imageSrc: String? = null
        var description: String? = null

        jsonReader.beginObject()
        while (jsonReader.hasNext()) {
            val name = jsonReader.nextName()
            when (name) {
                "imageSrc" -> imageSrc = jsonReader.nextString()
                "description" -> description = jsonReader.nextString()
                else -> jsonReader.skipValue()
            }
        }
        jsonReader.endObject()

        if (imageSrc != null && description != null) {
            return ListItem(imageSrc, description)
        } else {
            throw IllegalArgumentException("Bad json object for list item: imageSrc $imageSrc, description $description")
        }
    }

    protected abstract fun getItemsInputStream(): InputStream
}