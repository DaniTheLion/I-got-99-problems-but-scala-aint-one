import scala.annotation.tailrec
import scala.concurrent.duration.Duration

object P12 extends App {

  // for comprehension
  def decode[T](list: List[(Int, T)]): List[T] =
    for {
      (n, el) <- list
      _       <- 1 to n
    } yield el


  // flatMap
  def decode2[T](list: List[(Int, T)]): List[T] = list.flatMap { case (n, el) => List.fill(n)(el) }


  // foldLeft
  def decode3[T](list: List[(Int, T)]): List[T] = list.foldLeft(List[T]()) {
    case (acc, (n, el)) => acc ++ List.fill(n)(el)
  }


  val res = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  assert(res ==  List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e), s"Nope.. got: ${res}")

  println("alles gut!")
}

