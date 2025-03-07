/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var nameText: JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 600)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        nameText = JTextField("")
        nameText.bounds = Rectangle(50,200,500,100)
        nameText.addActionListener(this)
        nameText.addKeyListener(this)
        add(nameText)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50,350,225,100)
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(325,350,225,100)
        goodbyeButton.addActionListener(this)
        add(goodbyeButton)

        greetingLabel = JLabel("Enter in you name then click a button.")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        add(greetingLabel)



    }


    /**
     * Handle any UI events (e.g. button clicks)
     */

    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

            nameText -> {
                println("Name text changed!")
            }

            greetingLabel -> {
                println("Greetings bitch (O.O)")
            }

            helloButton -> {
                println("Hello Button Pressed!")
                var name = "stranger"
                greetingLabel.text = "Hi there ${nameText.text}!"
                greetingLabel.foreground = Color.GREEN
            }
            goodbyeButton -> {
                println("Goodbye Button Pressed!")
                greetingLabel.text = "YOUR UGLY ${nameText.text}!"
                greetingLabel.foreground = Color.RED
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key TYPED: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key PRESSED: ${e?.keyCode}!")

        if (e?.keyCode in KeyEvent.VK_ENTER..KeyEvent.VK_Z) {}
            println("Letter key pressed!")
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key RELEASED: ${e?.keyCode}!")
    }
}





