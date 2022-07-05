package com.github.nekoy3.jdk_discordbot

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.*
import javax.security.auth.login.LoginException


class BotBuild {
    private var TOKEN = "token"
    private var GUILD_ID = 0 //int guild_id

    @Test
    fun fileRead() {
        try {
            val file = File("..\\..\\..\\..\\config.txt")
            val filereader = FileReader(file)

            val ch = filereader.read() //文字コード(int)で取得
            println(ch.toChar())
        } catch (e: FileNotFoundException) { //ファイルが存在しないときの例外
            println("FileNotFoundException")
        } catch (e: IOException) { //readメソッドでの例外
            println("IOException")
        }
    }

    fun first() {
        //configファイルの読み込み
        fileRead()
        
        try {
            // Login 処理
            val jda = JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(SlashCommandListener()) //処理するクラスを追加するメソッド
                .setActivity(Activity.playing("作業")) // "～をプレイ中" の ～の部分
                .build()
            // ログインが完了するまで待つ
            jda.awaitReady()

            //guildをidから取得する
            val guild = jda.getGuildById(GUILD_ID)!!


            // 登録するコマンドを作成
            var registCommands = listOf<CommandData>()

            registCommands += Commands.slash("setting", "最初に一度行う初期設定用のコマンドです。")
                .addOption(OptionType.STRING, "name" , "名前を入力してください。")
                .addOption(OptionType.STRING, "id" , "学籍番号を入力してください。")

            registCommands += Commands.slash("in", "部屋に入室するときのコマンドです。")
                .addOption(OptionType.INTEGER, "time" , "退出予定時刻を4桁で入力してください", false)

            registCommands += Commands.slash("out", "部屋を退室するときのコマンドです。")
                    .addOption(OptionType.INTEGER, "time" , "時刻を4桁で入力してください。", false)

            // 指定したサーバーにコマンドを登録
            guild.updateCommands()
                .addCommands(registCommands) //Commands.slash単体でもそれらの配列であるCommandDataを投げても動作する
                .queue()

        } catch (e: LoginException) {
            e.printStackTrace()
        }
    }
}

fun main(){
    BotBuild().first()
}