class SignTest extends org.scalatest.FunSuite {
    test("Sign.print one line") {
        val sign = new Sign(new Lines(10, Array("lala", "bu")))
        assert(sign.get === "+---------+\n|         |\n| lala bu |\n|         |\n+---------+\n")
    }

    test("Sign.print two lines") {
        val sign = new Sign(new Lines(5, Array("lala", "bu")))
        assert(sign.get === "+------+\n|      |\n| lala |\n| bu   |\n|      |\n+------+\n")
    }

    test("Sign.print too long line") {
        val sign = new Sign(new Lines(5, Array("lalagag", "bu")))
        print(sign.get)
        assert(sign.get === "+-------+\n|       |\n| lalag |\n| ag bu |\n|       |\n+-------+\n")
    }
}