import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.EventTarget
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.text.Font
import javafx.stage.Stage

class MyApp : Application() {
    override fun start(primaryStage: Stage) {
        with(primaryStage) {
            hbox(10) {

                paddingH = 20.0
                paddingV = 10.0

                val label = label("Hello Kotlin")

                button("Increase Font").setOnAction {
                    label.font++
                }
            }
            show()
        }
    }
}

var Pane.paddingH: Number
    get() = (padding.left + padding.right) / 2
    set(value) {
        padding = Insets(padding.top, value.toDouble(), padding.bottom, value.toDouble())
    }
var Pane.paddingV: Number
    get() = (padding.bottom + padding.top) / 2
    set(value) {
        padding = Insets(value.toDouble(), padding.right, value.toDouble(), padding.left)
    }

fun EventTarget.hbox(spaceing: Number? = null, fn: HBox.() -> Unit) {
    val hbox = HBox()
    if (spaceing != null)
        hbox.spacing = spaceing.toDouble()

    when(this) {
        is Stage -> scene  = Scene(hbox)
        is Pane -> add(hbox)
    }

    fn(hbox)
}

fun Pane.label(text: String, fn: (Label.() -> Unit)? = null): Label  {
    val label = Label(text)
    add(Label(text))
    fn?.invoke(label)
    return label
}
fun Pane.button(text: String) = Button(text).apply {
    this@button.add(this)
}

fun Pane.add(node: Node): Pane {
    children.add(node)
    return this
}

operator fun Font.inc() = Font(size + 1 )

fun main(args: Array<String>) {
    launch(MyApp::class.java)
}