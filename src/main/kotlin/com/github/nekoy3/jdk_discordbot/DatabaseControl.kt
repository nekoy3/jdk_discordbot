package com.github.nekoy3.jdk_discordbot

import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class DatabaseControl {
    init {
        try {
            // JDBCドライバーの指定
            Class.forName("org.sqlite.JDBC")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
    fun createDatabaseAndTable() {
        @Entity
        data class User(
            @PrimaryKey(autoGenerate = true)
            val id: Int,

            var name: String,

            @ColumnInfo(name = "nenrei")
            var age: Int
        )
    }
}