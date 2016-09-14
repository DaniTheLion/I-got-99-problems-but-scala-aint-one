import scala.annotation.tailrec

object P3 extends App {
  @tailrec
  def nth[T](index: Int, l: List[T]): T = index match {
    case 0  => l.head
    case _  => nth(index - 1, l.tail)
  }


  assert(nth(2, List(1, 1, 2, 3, 5, 8)) == 2, "Nope..")
}



