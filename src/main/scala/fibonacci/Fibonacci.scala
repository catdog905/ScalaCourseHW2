package fibonacci

object Fibonacci {
  def fibonacci(limit: Long): BigInt = {
    @scala.annotation.tailrec
    def fibonacci(num: Long, a: BigInt, b: BigInt): BigInt = {
      num match {
        case num if num < 3 => b
        case num            => fibonacci(num - 1, b, a + b)
      }
    }
    fibonacci(limit, 1, 1)
  }
}
