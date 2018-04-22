object Main {
  def main(args: Array[String]) = {
    val limit = TerminalInfo.width
    val lines = new Lines(limit, args)
    val sign = new Sign(lines)
    print(sign.get)
  }
}