package com.hemmersbach.android


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

inline fun <reified T> Gson.fromJson(json: String) =
    this.fromJson<T>(json, object: TypeToken<T>() {}.type)

fun InputStream.toJsonString(): String? {
    var json: String? = null
    try {
        val size = this.available()
        val buffer = ByteArray(size)
        this.read(buffer)
        this.close()
        json = String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }

    return json
}
