import scala.annotation.tailrec
import scala.concurrent.duration.Duration

object P8 extends App {
  def compress[T](l: List[T]): List[T] = {
    l.foldLeft(List[T]()) {
      case(Nil, el: T) => el :: Nil
      case(acc, el) => if (el != acc.last) acc ::: el :: Nil else acc
    }
  }


  // Another version. Elegant!
  def compress2[T](l: List[T]): List[T] = l match {
    case x :: y :: xs => if (x == y) compress2(y :: xs) else x :: compress2(y :: xs)
    case _ => l
  }



  val res = compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  assert(res == List('a, 'b, 'c, 'a, 'd, 'e), s"Nope.. got: ${res}")


  val res2 = compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  assert(res2 == List('a, 'b, 'c, 'a, 'd, 'e), s"Nope.. got: ${res2}")

  println("alles gut!")
}