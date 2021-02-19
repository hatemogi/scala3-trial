import cats.effect.IO
import cats.effect.unsafe.implicits.global

@main def hello: Unit =
  val printer: IO[Unit] =
    IO { println("Hello world!") } *>
    IO { println(msg) }
  printer.unsafeRunSync()

def msg = "I was compiled by Scala 3. :)"

