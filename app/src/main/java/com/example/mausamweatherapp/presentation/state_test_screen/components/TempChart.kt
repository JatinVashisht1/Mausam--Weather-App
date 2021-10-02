package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

data class Point(val X: Float = 0f, val Y: Float = 0f)

@Composable
fun LineChart() {
    // Used to record the zoom size
    var scale by remember { mutableStateOf(1f) }
    val state = rememberTransformableState {
            zoomChange, panChange, rotationChange ->
        scale*=zoomChange
    }
    val point = listOf(
        Point(10f, 10f), Point(50f, 100f), Point(100f, 30f),
        Point(150f, 200f), Point(200f, 120f), Point(250f, 10f),
        Point(300f, 280f), Point(350f, 100f), Point(400f, 10f),
        Point(450f, 100f), Point(500f, 200f)
    )
    val path = Path()
    for ((index, item) in point.withIndex()) {
        if (index == 0) {
            path.moveTo(item.X*scale, item.Y)
        } else {
            path.lineTo(item.X*scale, item.Y)
        }
    }
    val point1 = listOf(
        Point(10f, 210f), Point(50f, 150f), Point(100f, 130f),
        Point(150f, 200f), Point(200f, 80f), Point(250f, 240f),
        Point(300f, 20f), Point(350f, 150f), Point(400f, 50f),
        Point(450f, 240f), Point(500f, 140f)
    )
    val path1 = Path()
    path1.moveTo(point1[0].X*scale, point1[0].Y)
    path1.cubicTo(point1[0].X*scale, point1[0].Y, point1[1].X*scale, point1[1].Y, point1[2].X*scale, point1[2].Y)
    path1.cubicTo(point1[3].X*scale, point1[3].Y, point1[4].X*scale, point1[4].Y, point1[5].X*scale, point1[5].Y)
    path1.cubicTo(point1[6].X*scale, point1[6].Y, point1[7].X*scale, point1[7].Y, point1[8].X*scale, point1[8].Y)
    path1.cubicTo(point1[7].X*scale, point1[7].Y, point1[8].X*scale, point1[8].Y, point1[9].X*scale, point1[9].Y)

    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.White)
            // Monitor gesture scaling
            .graphicsLayer(
            ).transformable(state)
    ) {
        // draw  X Axis  Y Axis
        drawLine(
            start = Offset(10f, 300f),
            end = Offset(10f, 0f),
            color = Color.Black,
            strokeWidth = 2f
        )
        drawLine(
            start = Offset(10f, 300f),
            end = Offset(510f, 300f),
            color = Color.Black,
            strokeWidth = 2f
        )
        // draw path
        drawPath(
            path = path,
            color = Color.Blue,
            style = Stroke(width = 2f)
        )
        drawPath(
            path = path1,
            color = Color.Green,
            style = Stroke(width = 2f)
        )
    }
}