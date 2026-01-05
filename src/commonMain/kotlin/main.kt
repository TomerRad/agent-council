import com.soywiz.korge.Korge
import com.soywiz.korge.view.RoundRect
import com.soywiz.korge.view.graphics
import com.soywiz.korge.view.position
import com.soywiz.korge.view.roundRect
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korim.paint.NoneFiller.fill

suspend fun main() = Korge(width = 480, height = 640, title = "2048", bgcolor = RGBA(253, 247, 240)) {

    val cellSize = views.virtualWidth / 5.0

    val fieldSize = 4 * cellSize + 50
    val leftIndent = (views.virtualWidth - fieldSize) / 2
    val topIndent = 150.0

    val bgField = roundRect(fieldSize, fieldSize, 5.0, fill = Colors["#b9aea0"]) {
        position(leftIndent, topIndent)
    }
    addChild(bgField)

    graphics {
        position(leftIndent, topIndent)

        fill(Colors["#cec0b2"]) {
            for (i in 0..3) {
                for (j in 0..3) {
                    roundRect(cellSize, cellSize, 5.0) {
                        position(leftIndent + 10 + (10 + cellSize) * i, topIndent + 10 + (10 + cellSize) * j)
                    }
                }
            }
        }
    }
}