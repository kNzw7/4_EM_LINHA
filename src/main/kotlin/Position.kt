import pt.isel.canvas.*

data class Position (val row: Int, val column: Int)


val ALL_POSITIONS: List<Position> =
    (7 until GRID_WIDTH * GRID_HEIGHT).map { Position(it % GRID_HEIGHT, it / GRID_WIDTH) }

fun directionOf(key: Int, disc:Disc): Direction = when (key) {
    LEFT_CODE -> Direction.LEFT
    RIGHT_CODE -> Direction.RIGHT
    DOWN_CODE -> Direction.DOWN
    else -> disc.dir
}

fun Disc.direction(key: Int) = pos + directionOf(key, this)

fun discDir(key: Int, connect4: Connect4): Disc {
    val a= connect4.falling.direction(key)

    return if (connect4.fixed.any { it.pos == a }) connect4.falling
    else connect4.falling.copy(dir = directionOf(key, connect4.falling))
}

//val ALL_POSITIONS: List<Position> =
  //  (0 until GRID_HEIGHT * GRID_WIDTH).map { Position(it % GRID_WIDTH, it / GRID_WIDTH) }

//operator fun Connect4.plus( dir :Direction ) = Position( falling.pos.row + dir.dx() , falling.pos.column + dir.dy() )
//operator fun Connect4.directPos(direction: Direction)= falling.pos + direction



