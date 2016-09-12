object P1 extends App {
  def last[T](l: List[T]): T = l match {
    case Nil      => throw new Exception("No last element for an empty list.")
    case x :: Nil => x
    case x :: xs  => last(xs)
  }

  assert(last(List(1, 1, 2, 3, 5, 8)) == 8, "Nope..")
}



