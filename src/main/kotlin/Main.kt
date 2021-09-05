import pt.isel.canvas.*

const val GRID_WIDTH  =7
const val GRID_HEIGHT =7
const val STATUS_BAR  =40
const val CIRCLE_SIDE =74
const val TEXT_BASE   =10
const val RADIUS      = 37

data class Connect4( val fixed: List<Disc>, val falling: Disc, val score:Pair<Int,Int> )
data class Disc(val player: Player, val pos: Position)

enum class Player{ RED, YELLOW }




fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH * CIRCLE_SIDE, 7 * CIRCLE_SIDE, WHITE)
        var connect4 = Connect4(emptyList(), Disc(Player.RED, Position(3, 0)), Pair(0, 0))
        cv.drawRect(0, 1 * CIRCLE_SIDE, GRID_WIDTH * CIRCLE_SIDE, (GRID_HEIGHT-1) * CIRCLE_SIDE, BLUE)
        drawGrid(cv)
        drawDisc(cv)
        drawStatus(cv)
        println(ALL_POSITIONS.size)
    }
    onFinish {
    }
}






/*

fun main () {
    onStart {
        val cv = Canvas(GRID_WIDTH * CIRCLE_SIDE, GRID_HEIGHT * CIRCLE_SIDE + STATUS_BAR, WHITE)
        var connect4 = Connect4(emptyList(), Disc(Player.RED, Position(3, 0)), Pair(0, 0))
        cv.drawArena()
        cv.drawCircles()
        cv.drawGRID()
        cv.drawStatus()

        println(ALL_POSITIONS)

        cv.onKeyPressed {
       //     connect4 = connect4.move()
            cv.drawArena()


        }
    }

    onFinish {
        println("EPOCA ESPECIAL")
    }
}
/*
fun Connect4.move() :Connect4 {
 //   val newPos=



}
        */