import scala.annotation.tailrec

object P4 extends App {
  def length[T](l: List[T]): Int = {

    @tailrec
    def lengthHelper[S](n: Int, lt: List[S]): Int = lt match {
      case Nil       => n
      case x :: xs   => lengthHelper(n + 1, xs)
    }

    lengthHelper(0, l)
  }

  assert(length(List(1, 1, 2, 3, 5, 8)) == 6, "Nope..")
}



