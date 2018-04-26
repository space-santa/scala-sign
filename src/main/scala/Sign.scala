class Sign(val lines: Lines) {
  private def topOrBottom = "+" + "-" * (lines.maxLineLength + 2) + "+"

  private def wrapLine(line: String): String = {
    "| " + line + " " * (lines.maxLineLength - line.length) + " |"
  }

  private def emptyLine = wrapLine("")

  def get: String = {
    var result = topOrBottom + "\n"
    result += emptyLine + "\n"

    for (line <- lines.get) {
      result += wrapLine(line) + "\n"
    }

    result += emptyLine + "\n"
    result += topOrBottom + "\n"
    return result
  }
}

object Sign {
  def maxAllowedLineLength(terminalWidth: Int): Int = {
    return terminalWidth - 4
  }
}
