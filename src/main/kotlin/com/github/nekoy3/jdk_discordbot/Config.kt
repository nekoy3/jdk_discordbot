package com.github.nekoy3.jdk_discordbot

import java.io.*
import java.util.*
import kotlin.system.exitProcess

class Config() {
    var TOKEN = ""
    var guildid: Long = 0
    init {
        try {
            val file = File("setting.properties")
            val prop = Properties()
            FileInputStream(file).use { prop.load(it) }

            //すべてのプロパティを出力します
            prop.stringPropertyNames()
                .associateWith {prop.getProperty(it)}
                .forEach { println(it) }

            //キーから値を取り出す
            TOKEN = prop.getProperty("token")
            guildid = prop.getProperty("guildid").toLong()

        } catch (e: Exception) {
            e.printStackTrace()
            makeConfig()
            exitProcess(-1)
        }
    }

    fun makeConfig() {
        try {
            FileInputStream(File("setting.properties")).use { fis ->
                FileOutputStream(File("setting.properties")).use { fos ->
                    val properties = Properties()
                    properties.store(fos, "Comments")
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
