package fi.jara.thesis.thesisnative.listitems.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.*
import java.io.InputStream

abstract class ImageLoader {
    suspend fun loadImage(uri: String): Bitmap {
        return withContext(Dispatchers.IO) {
            getImageInputStream(uri).use {
                BitmapFactory.decodeStream(it)
            }
        }
    }

    protected abstract fun getImageInputStream(uri: String): InputStream
}