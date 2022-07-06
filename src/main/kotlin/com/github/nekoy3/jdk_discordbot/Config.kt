package com.github.nekoy3.jdk_discordbot


import java.nio.file.Files
import java.nio.file.Paths
import java.io.*
import java.util.*
import kotlin.system.exitProcess

class Config {
    @JvmName("getProp1")
    fun getProp(): Properties {
        try {
            val file = File("setting.properties")
            val prop = Properties()
            FileInputStream(file).use { prop.load(it) }
            return prop
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            makeConfig()
            exitProcess(-1)
        }
    }

    fun makeConfig() {
        val f = Paths.get("setting.properties")
        try {
            if (!Files.exists(f)) {
                Files.createFile(f)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    val prop =  getProp()
    val TOKEN = prop.getProperty("token")
    val GUILDID = prop.getProperty("guildid")
}
