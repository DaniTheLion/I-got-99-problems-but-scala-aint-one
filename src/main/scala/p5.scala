import scala.annotation.tailrec

object P5 extends App {
  def reverse[T](l: List[T]): List[T] = {

    @tailrec
    def reverseHelper[S](list: List[S], revList: List[S]): List[S] = list match {
      case Nil       => revList
      case x :: xs   => reverseHelper(xs, x :: revList)
    }
    reverseHelper(l, Nil)
  }

  assert(reverse(List(1, 1, 2, 3, 5, 8)) == List(8, 5, 3, 2, 1, 1), "Nope..")
}



