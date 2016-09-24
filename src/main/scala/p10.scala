import scala.annotation.tailrec
import scala.concurrent.duration.Duration

object P10 extends App {
  def encode[T](list: List[T]): List[(Int, T)] =
    P9.pack(list) map (l => (l.size, l.head))


  val res = encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  assert(res == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)), s"Nope.. got: ${res}")

  println("alles gut!")
}

