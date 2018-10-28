package main

import org.hexworks.zircon.api.Screens
import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.builder.data.TileBuilder
import org.hexworks.zircon.api.color.ANSITileColor
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.grid.TileGrid

class DisplayController(tileGrid: TileGrid) {
    private val gameScreen = Screens.createScreenFor(tileGrid)

    private val gameLayer = gameScreen.layers.first()

    private val snakeTile = snakeTile()

    fun draw() {
        gameLayer.setTileAt(Position.create(2, 3), snakeTile)
        gameScreen.display()
    }

    private fun snakeTile() = tileBuilder {
        withBackgroundColor(ANSITileColor.GREEN)
        withForegroundColor(ANSITileColor.WHITE)
        withCharacter('o')
    }
}

fun tileBuilder(lambda: TileBuilder.() -> Unit): Tile {
    return Tiles.newBuilder().apply(lambda).build()
}

