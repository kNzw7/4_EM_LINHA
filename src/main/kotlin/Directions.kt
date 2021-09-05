import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE

enum class Direction(val dx:Int, val dy:Int, val key:Int) {
    DOWN(0, 1, DOWN_CODE), LEFT(-1, 0, LEFT_CODE), RIGHT(1, 0, RIGHT_CODE)
}