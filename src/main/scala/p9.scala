import scala.annotation.tailrec
import scala.concurrent.duration.Duration

object P9 extends App {

  def pack[T](l: List[T]): List[List[T]] = l match {
    case x :: xs => l.takeWhile(_.equals(x)) :: pack(l.dropWhile(_.equals(x)))
    case Nil => Nil
  }

  // Using span instead of takeWhile and dropWhile:
  def pack2[T](l: List[T]): List[List[T]] = l match {
    case x :: xs => l.span(_.equals(x)) match { case (pref, suff) => pref :: pack2(suff) }
    case Nil => Nil
  }

  val res = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  assert(res == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)), s"Nope.. got: ${res}")

  val res2 = pack2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  assert(res2 == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)), s"Nope.. got: ${res2}")

  println("alles gut!")
}

