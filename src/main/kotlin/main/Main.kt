package main

import org.hexworks.zircon.api.AppConfigs
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.builder.application.AppConfigBuilder


fun main(args: Array<String>) {

    val grid = SwingApplications.startTileGrid(
            tileConfig {
                withSize(Sizes.create(30, 20))
            }
    )

    DisplayController(grid).apply {
        while(true){
            draw()
        }
    }

}

fun tileConfig(lambda: AppConfigBuilder.() -> Unit) =
        AppConfigs.newConfig().apply(lambda).build()



