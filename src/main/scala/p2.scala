import scala.annotation.tailrec

object P2 extends App {
  @tailrec
  def penultimate[T](l: List[T]): T = l match {
    case Nil             => throw new NoSuchElementException("No penultimate element for an empty list.")
    case x :: y :: Nil   => x
    case x :: xs         => penultimate(xs)
  }
  assert(penultimate(List(1, 1, 2, 3, 5, 8)) == 5, "Nope..")
}



