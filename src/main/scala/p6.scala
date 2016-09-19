import scala.annotation.tailrec

object P6 extends App {
  def isPalindrome[T](l: List[T]): Boolean = {

    def reverse[T](l: List[T]): List[T] = {
      @tailrec
      def reverseHelper[S](list: List[S], revList: List[S]): List[S] = list match {
        case Nil       => revList
        case x :: xs   => reverseHelper(xs, x :: revList)
      }
      reverseHelper(l, Nil)
    }

    l == reverse(l)
  }

  assert(isPalindrome(List(1, 2, 3, 2, 1)) == true, "Nope..")
  assert(isPalindrome(List(1, 2, 3, 2, 14)) == false, "Nope..")
  assert(isPalindrome(List("a", "x", "o", "o", "x", "a")) == true, "Nope..")
}



