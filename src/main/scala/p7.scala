import scala.annotation.tailrec

object P7 extends App {
  def flatten[T](l: List[Any]): List[T] = {
    l.foldLeft(List[T]()) {
      case(xs, ys: List[_]) => xs ::: flatten(ys)
      case(xs, x: T) => xs ::: x :: Nil
      case xs => Nil
    }
  }

  val res = flatten(List(List(1, 2)))
  assert(res == List(1,2), s"Nope.. got: ${res}")


  val res2 = flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  assert(res2 == List(1,1,2, 3,5,8), s"Nope.. got: ${res2}")
}



