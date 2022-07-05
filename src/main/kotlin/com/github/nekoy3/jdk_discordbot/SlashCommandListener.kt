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

//リファレンス https://ci.dv8tion.net/job/JDA5/javadoc/net/dv8tion/jda/api/interactions/commands/CommandInteractionPayload.html
// https://ci.dv8tion.net/job/JDA5/javadoc/net/dv8tion/jda/api/interactions/commands/SlashCommandInteraction.html
// ↑ SlashCommandInteractionEventインタフェースが所持するインスタンスメソッド
//これを参考にコマンドから得たOptionを取得したり、コマンド実行チャンネル、実行者のユーザーidを取得する事が出来る。
//例:(動作検証はしておらず、リファレンスをなんとなく見ただけ)
//event.getOption(String name) nameと同じ引数名で記述された内容を返す、無ければNullを返す
//.getMember() Member型のメンバーの情報を返す
//MemberとUser型の違いがよく分からないが、Member型に対して.getUser()してUserを取得して、getId()するとユーザーのidを取得できる（かも）
//↑https://www.tabnine.com/code/java/methods/net.dv8tion.jda.core.entities.User/getId
