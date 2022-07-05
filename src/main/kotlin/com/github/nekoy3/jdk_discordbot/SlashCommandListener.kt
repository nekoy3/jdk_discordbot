package com.github.nekoy3.jdk_discordbot

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SlashCommandListener : ListenerAdapter() {
    //ここらへんにコマンドごとに処理用のメソッド作ったほうがスッキリするかも

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        // test コマンドなら処理をする。
//        if (event.name == "test") {
//            // コマンド送信者に対して、その人にだけ見えるメッセージ(setEphemeral(true))として返信する。
//            event.reply("This is test command!").setEphemeral(true).queue()
//        }

        when(event.name){ //コマンド名により処理を分岐
            "test" -> event.reply("This is test command!").setEphemeral(true).queue()

            "setting" -> event.reply("This is test command!").setEphemeral(true).queue()

            "in" -> event.reply("This is test command!").setEphemeral(true).queue()

            "out" -> event.reply("This is test command!").setEphemeral(true).queue()

        }
    }
}