package com.whiff.plug.connection

import com.whiff.plug.cons.CustomPlayer
import com.whiff.plug.types.Types
import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import java.util.*

object Connector {
    private const val url = "mongodb+srv://Whiffmaster:MVngsAWnAFFGCSma@cluster0.pvkvq1u.mongodb.net"
    private const val databaseName = "plugins"


    private val client = KMongo.createClient(url)
    private val database = client.getDatabase(databaseName)

    private fun getCollection(name: String) = database.getCollection(name)

    private fun addPlayer(doc: Types.CustomPlayer) {
        database.getCollection<Types.CustomPlayer>("Players").insertOne(doc)
    }
    fun getPlayer(uuid:String): Types.CustomPlayer {
        val doc = getCollection("Players").findOne(Types.CustomPlayer::uuid eq uuid)
        if ( doc != null){
            return CustomPlayer(doc["name"].toString(),doc["uuid"].toString())
        }
        val name = Bukkit.getPlayer(UUID.fromString(uuid))?.name ?: "Unknown"
        val newPlayer = CustomPlayer(name,uuid)
        addPlayer(newPlayer)
        return newPlayer
    }

    fun getStructure(name: String): List<Block> {
        val doc = getCollection("Structures").findOne(Types.Structure::name eq name)
        if (doc != null) return doc["blocks"] as List<Block>
        return listOf()
    }

}