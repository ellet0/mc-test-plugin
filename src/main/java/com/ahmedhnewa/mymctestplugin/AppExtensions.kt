package com.ahmedhnewa.mymctestplugin

import okhttp3.OkHttpClient
import okhttp3.Request
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.swing.text.html.HTML

//    val chatId = "1153244959"

fun sendMessageToTelegram(player: Player, s: String, parseMode: String = HTML::class.simpleName ?: "html", chatId: String = "-635965190") {
    val url = "https://api.telegram.org/bot${Constants.BOT_TOKEN}/sendMessage?chat_id=$chatId&text=$s&parse_mode=$parseMode"
    sendHttpReq(url, onSuccess = {
        player.sendMessage(it)
        player.sendMessage("تم ارسال الرسالة بكروب التليجرام")
        player.sendMessage(url)
    })
}

var client = OkHttpClient()

@Throws(IOException::class)
fun sendHttpReq(url: String, onSuccess: (msg: String) -> Unit = {}, onFailed: (error: String) -> Unit = {}) {
    var res = ""
    Bukkit.getServer().scheduler.runTaskAsynchronously(JavaPlugin.getPlugin(Main::class.java), Runnable {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) onFailed(response.message)
            res = response.body?.string() ?: ""
            onSuccess(res)
        }
    })
//    return res
}

@EventHandler
fun AsyncPlayerChatEvent() {
    
}


@Deprecated("Test")
fun sendHttpReqOld(reqUrl: String, onSuccess: (msg: String) -> Unit = {}, onFailed: (error: String) -> Unit = {}) {

    Bukkit.getServer().scheduler.runTaskAsynchronously(
        JavaPlugin.getPlugin(Main::class.java),
        Runnable {
            try {
                val url = URL(reqUrl)
                //                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                val connection = url.openConnection()
                //                connection.setRequestMethod("GET");
                val reader = BufferedReader(
                    InputStreamReader(connection.getInputStream())
                )
                var inputLine: String?
                while (reader.readLine().also { inputLine = it } != null) {
                    println(inputLine)
                    inputLine?.let { onSuccess(it) }
                }
                reader.close()
            } catch (e: IOException) {
                e.message?.let { onFailed(it) }
                println(e.message)
                e.printStackTrace()
            }
        })
}
