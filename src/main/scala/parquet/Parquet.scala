package parquet

import parquet.ParquetTypes.{Economy, ParquetType, Premium}

import scala.math.pow;

case class Parquet private (parquetType: ParquetType, floorsNumber: Int, length: Int, width: Int, height: Int) {
  def cost(): Int = {
    def space_size(f: (Int, Int) => Int): Int = f(f(length, width), height)
    (parquetType, floorsNumber) match {
      case (parquetType, floorsNumber) if parquetType == Premium && floorsNumber < 5 =>
        pow(3, floorsNumber).intValue() * space_size(_ + _)
      case (parquetType, floorsNumber) if parquetType == Premium && floorsNumber >= 5 =>
        pow(2, floorsNumber).intValue() * space_size(_ + _)
      case (parquetType, floorsNumber) if parquetType == Economy =>
        space_size(_ * _) + floorsNumber * 10000
    }
  }
}

object ParquetTypes extends Enumeration {
  type ParquetType = Value

  val Premium, Economy = Value
}
object Parquet {
  def apply(parquetType: ParquetType, floorsNumber: Int, length: Int, width: Int, height: Int): Parquet = {
    if (floorsNumber <= 0)
      throw new FloorsNumberCanNotBeLessEqualZero()
    if (length <= 0)
      throw new LengthCanNotBeLessEqualZero()
    if (width <= 0)
      throw new WidthCanNotBeLessEqualZero()
    if (height <= 0)
      throw new HeightCanNotBeLessEqualZero()
    new Parquet(parquetType, floorsNumber, length, width, height)
  }
}
