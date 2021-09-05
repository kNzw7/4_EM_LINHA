import pt.isel.canvas.*

fun drawStatus(cv:Canvas) {
    cv.drawRect(0,cv.height-STATUS_BAR,cv.width,STATUS_BAR, WHITE)
    cv.drawText(CIRCLE_SIDE,cv.height-TEXT_BASE,"", GREEN)
}

fun drawSpaces(cv : Canvas) {
    ALL_POSITIONS.map { cv.drawCircle(it.row * CIRCLE_SIDE + RADIUS, it.column * CIRCLE_SIDE + RADIUS, RADIUS, WHITE) }
}

fun Canvas.drawDisc (disc:Disc) {
    drawCircle(disc.pos.row * CIRCLE_SIDE + RADIUS ,disc.pos.column * CIRCLE_SIDE + RADIUS, RADIUS ,if (disc.player==Player.RED) RED else YELLOW )
}

    fun drawGrid(cv: Canvas) {
        (CIRCLE_SIDE..cv.height step CIRCLE_SIDE).forEach { cv.drawLine(0, it, cv.width, it, BLACK, 1) }
        (CIRCLE_SIDE..cv.width step CIRCLE_SIDE).forEach { cv.drawLine(it, 0, it, cv.height, BLACK, 1) }
    }

fun Canvas.drawArena() {
    drawRect(0, CIRCLE_SIDE, width, height - STATUS_BAR, BLUE)

    (0..width step CIRCLE_SIDE).forEach {
        drawCircle(CIRCLE_SIDE / 2 + CIRCLE_SIDE * (it), CIRCLE_SIDE + CIRCLE_SIDE / 2, CIRCLE_SIDE / 2, WHITE)
    }


}

