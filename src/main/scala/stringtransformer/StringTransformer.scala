package stringtransformer

object StringTransformer {
  def duplicatedString(string: String): String = string + string
  def halfOfString(string: String): String = string.substring(0, string.length / 2)
  def reversedString(string: String): String = string.reverse
  def transformer(string: String)(transform: (String) => String): String = transform(string)
}
