import pt.isel.canvas.*

const val GRID_WIDTH = 7
const val GRID_HEIGHT = 7
const val STATUS_BAR = 40
const val CIRCLE_SIDE = 74
const val TEXT_BASE = 10
const val RADIUS = 33
const val CENTER = 4

data class Connect4(val fixed: List<Disc>, val falling: Disc, val score: Pair<Int, Int>)
data class Disc(val player: Player, val pos: Position, val dir: Direction)

enum class Player { RED, YELLOW }

fun Position.isValid() = row in 0 until GRID_WIDTH && column in 0 until GRID_HEIGHT

fun Connect4.move(): Connect4 {
    val newPos = (this.falling.pos + this.falling.dir).isValid()
    return this
}


fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH * CIRCLE_SIDE, GRID_HEIGHT * CIRCLE_SIDE + STATUS_BAR, WHITE)
        var connect4 = Connect4(emptyList(), Disc(Player.RED, Position(3, 0), Direction.UP), Pair(0, 0))
        cv.drawRect(0, 1 * CIRCLE_SIDE, GRID_WIDTH * CIRCLE_SIDE, (GRID_HEIGHT - 1) * CIRCLE_SIDE, BLUE)
        drawGrid(cv)
        drawSpaces(cv)
        cv.drawDisc(connect4.falling)
        connect4.drawStatus(cv)
        println(ALL_POSITIONS.size)
    }
    onFinish {
        println("EPOCA ESPECIAL")
    }
}

// mover a peça
// verificar colisoes
