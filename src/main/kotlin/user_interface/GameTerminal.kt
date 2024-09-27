package fr.user_interface

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import javafx.stage.Stage


class GameTerminal : Application() {
    override fun start(primaryStage: Stage) {
        val textArea = TextArea()
        textArea.isEditable = false

        val root = VBox()
        root.children.add(textArea)

        val scene = Scene(root, 600, 400)
        primaryStage.title = "Game Terminal"
        primaryStage.scene = scene
        primaryStage.show()

        // Example of writing to the terminal
        textArea.appendText("Welcome to the game!\n")
    }
}

fun main() {
    Application.launch(GameTerminal::class.java)
}