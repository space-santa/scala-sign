import scala.collection.mutable.ListBuffer

class Lines(val limit: Int) {
    private var lines = ListBuffer.empty[String]

    def this(limit: Int, words: Array[String]) = {
        this(limit)
        lines = Lines.makeLines(limit, words)
    }

    def get: List[String] = lines.toList

    def maxLineLength: Int = {
        var max = 0

        for (line <- lines) {
            if (line.length > max) {
                max = line.length
            }
        }

        return max
    }
}

object Lines {
    def makeLines(limit: Int, words: Array[String]): ListBuffer[String] = {
        val checkedWords = makeSureWordsAreShorterThanLimit(words, limit)
        var buf = ListBuffer.empty[String]
        var line = ""

        for (word <- checkedWords) {
            if (withinLimit(line, word, limit)) {
                if (line.length > 0) {
                    line += " "
                }

                line += word
            } else {
                buf += line
                line = word
            }
        }

        buf += line
        return buf.filter(_.length > 0)
    }

    def makeSureWordsAreShorterThanLimit(words: Array[String], limit: Int): Array[String] = {
        var buf = ListBuffer.empty[String]

        for (word <- words) {
            if (word.length > limit) {
                val parts = splitWordAtLimit(word, limit)

                for (part <- parts) {
                    buf += part
                }
            } else {
                buf += word
            }
        }

        return buf.toArray
    }

    def splitWordAtLimit(word: String, limit: Int): Array[String] = {
        var buf = ListBuffer.empty[String]
        var tmpWord = ""

        for(c <- word.toList) {
            tmpWord += c

            if (tmpWord.length == limit) {
                buf += tmpWord
                tmpWord = ""
            }
        }

        if (tmpWord.length > 0) {
            buf += tmpWord
        }

        return buf.toArray
    }

    def withinLimit(line: String, word: String, limit: Int): Boolean = {
        return line.length + 1 + word.length <= limit
    }
}