
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

// funçao para verificar se a posiçao  onde irá cair é valida
fun Position.isValid(list:List<Disc>) =  row in 0 until GRID_WIDTH && column in 0 until GRID_HEIGHT && this !in (ALL_POSITIONS-list)

fun Connect4.placed(key:Int): Connect4 {
    val moving = falling.move(key,this)
    val validPos = moving.pos.isValid(fixed)
    return if (!validPos) this else this.copy(falling= moving)
}

fun Disc.move(key:Int, connect4: Connect4):Disc{
    return if(pos.column == 0) when (dir) {
        Direction.RIGHT,Direction.LEFT ->discDir(key,connect4)
        Direction.DOWN -> discDir(key,connect4)//copy(pos=direction(key),dir=Direction.DOWN)
        else -> this
    }
     else copy(pos = pos + dir, dir= Direction.DOWN)
}

fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH * CIRCLE_SIDE, GRID_HEIGHT * CIRCLE_SIDE + STATUS_BAR, WHITE)
        var connect4 = Connect4(emptyList(), Disc(Player.RED, Position(3, 0), Direction.STOP), Pair(0, 0))
        cv.drawArena(connect4)

        cv.onKeyPressed {
           connect4 = connect4.copy(falling = connect4.falling.move(it.code,connect4))
           cv.drawArena(connect4)
        }
        cv.onTimeProgress(250){
            connect4 = connect4.placed(/*merda de key?????*/)
        }
    }
    onFinish {
        println("EPOCA ESPECIAL")
    }
}

// mover a peça
// verificar colisoes
