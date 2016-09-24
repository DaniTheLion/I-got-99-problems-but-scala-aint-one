import scala.annotation.tailrec
import scala.concurrent.duration.Duration

object P11 extends App {
  def encodeModified[T](list: List[T]): List[Any] =
    P9.pack(list) map {
      case List(x) => x
      case l       => (l.size, l.head)
    }

  val res = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  assert(res ==  List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)), s"Nope.. got: ${res}")

  println("alles gut!")
}

