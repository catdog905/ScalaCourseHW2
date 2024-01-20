package stringtransformer

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import stringtransformer.StringTransformer._

class StringTransformerSpec extends AnyFlatSpec with Matchers {
  "duplicatedString" should "return duplicated string" in {
    duplicatedString("Hello") shouldEqual "HelloHello"
  }

  "halfOfString" should "return half of odd string" in {
    halfOfString("Hello") shouldEqual "He"
  }

  "halfOfString" should "return half of even string" in {
    halfOfString("HelloWorld") shouldEqual "Hello"
  }

  "reversedString" should "return reversed version of the string" in {
    reversedString("Hello") shouldEqual "olleH"
  }

  "transformer" should "make closure over string" in {
    val func: (String => String) => String = transformer("Hello")
    func(duplicatedString) shouldEqual "HelloHello"
    func(halfOfString) shouldEqual "He"
    func(reversedString) shouldEqual "olleH"
  }
}
