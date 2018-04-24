class LinesTestMakeLines extends org.scalatest.FunSuite {
  test("Lines.makeLines count is 2") {
    val lines = Lines.makeLines(10, Array("lala", "bububu"))
    assert(lines.length === 2)
    assert(lines.head === "lala")
    val arr = lines.toArray
    assert(arr(1) === "bububu")
  }

  test("Lines.makeLines count is 1") {
    val lines = Lines.makeLines(20, Array("lala", "bububu"))
    assert(lines.length === 1)
    assert(lines.head === "lala bububu")
  }
}

class LinesTestWithinLimit extends org.scalatest.FunSuite {
  test("Lines.withinLimit yes") {
    assert(Lines.withinLimit("lala", "bu", 7))
  }

  test("Lines.withinLimit no") {
    assert(!Lines.withinLimit("lala", "bu", 6))
  }
}

class LinesTestThis extends org.scalatest.FunSuite {
  test("Lines.this limit 5 two lines") {
    val lines = new Lines(5, Array("la", "meh", "bbhhmm"))
    assert(lines.maxLineLength === 5)
    val arr = lines.get.toArray
    assert(arr(0) === "la")
    assert(arr(1) === "meh")
    assert(arr(2) === "bbhhm")
    assert(arr(3) === "m")
  }
}

class LinesTestSplitWordAtLimit extends org.scalatest.FunSuite {
  test("Lines.splitWordAtLimit with one spare") {
    val result = Lines.splitWordAtLimit("abcdefghijklmnop", 5)
    assert(result.length === 4)
    assert(result(0) === "abcde")
    assert(result(1) === "fghij")
    assert(result(2) === "klmno")
    assert(result(3) === "p")
  }

  test("Lines.splitWordAtLimit exactly on limit") {
    val result = Lines.splitWordAtLimit("abcdefghijklmno", 5)
    assert(result.length === 3)
    assert(result(0) === "abcde")
    assert(result(1) === "fghij")
    assert(result(2) === "klmno")
  }
}
