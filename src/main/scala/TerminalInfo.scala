import org.jline.terminal.TerminalBuilder

object TerminalInfo {
    def width: Int = {
        return TerminalBuilder.builder().system(true).build().getWidth()
    }
}