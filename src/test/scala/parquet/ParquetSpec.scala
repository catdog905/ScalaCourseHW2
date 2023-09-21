package parquet

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import parquet.ParquetTypes.{Economy, Premium}

class ParquetSpec extends AnyFlatSpec with Matchers {
  "parquet with non-positive floors number" should "fail to instantiates" in {
    assertThrows[FloorsNumberCanNotBeLessEqualZero] {
      Parquet(Premium, -1, 22, 42, 82)
    }
    assertThrows[FloorsNumberCanNotBeLessEqualZero] {
      Parquet(Economy, -1, 22, 42, 82)
    }
  }

  "parquet with non-positive length" should "fail to instantiates" in {
    assertThrows[LengthCanNotBeLessEqualZero] {
      Parquet(Premium, 1, -22, 42, 82)
    }
    assertThrows[LengthCanNotBeLessEqualZero] {
      Parquet(Economy, 1, -22, 42, 82)
    }
  }

  "parquet with non-positive width" should "fail to instantiates" in {
    assertThrows[WidthCanNotBeLessEqualZero] {
      Parquet(Premium, 1, 22, -42, 82)
    }
    assertThrows[WidthCanNotBeLessEqualZero] {
      Parquet(Economy, 1, 22, -42, 82)
    }
  }

  "parquet with non-positive height" should "fail to instantiates" in {
    assertThrows[HeightCanNotBeLessEqualZero] {
      Parquet(Premium, 1, 22, 42, -82)
    }
    assertThrows[HeightCanNotBeLessEqualZero] {
      Parquet(Economy, 1, 22, 42, -82)
    }
  }

  "cost of parquet" should "calculate correctly" in {
    Parquet(Premium, 2, 2, 3, 4).cost() shouldEqual 81
    Parquet(Premium, 4, 3, 4, 5).cost() shouldEqual 972
    Parquet(Premium, 5, 1, 2, 3).cost() shouldEqual 192
    Parquet(Premium, 11, 1, 2, 3).cost() shouldEqual 12288
    Parquet(Economy, 11, 5, 6, 3).cost() shouldEqual 110090
  }
}
