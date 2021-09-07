import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE



fun Direction?.dx(): Int = this?.dx ?: 0

fun Direction?.dy() = this?.dy ?: 0

operator fun Position.plus(dir: Direction) = Position(row + dir.dx(), column + dir.dy())

enum class Direction(val dx: Int, val dy: Int, val key: Int) {
    DOWN(0, 1, DOWN_CODE), LEFT(-1, 0, LEFT_CODE), RIGHT(1, 0, RIGHT_CODE), STOP(0, 0, 'P'.code)
}