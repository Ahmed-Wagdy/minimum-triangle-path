package model

import cats.effect.IO

case class Triangle(value: List[List[Int]]) {
  require(value.nonEmpty,
    s"expected 'Triangle' to be nonEmpty")
  require(isValidTriangle, "not a valid triangle")

  private def isValidTriangle: Boolean = value match {
    case Nil => false
    case head :: Nil => head.size == 1
    case _ => value.sliding(2).forall {
      case Seq(level, nextLevel) => nextLevel.size == level.size + 1
      case _ => false
    }
  }
}

object Triangle {
  def fromLines(lines: List[String]): IO[Triangle] =
    IO.delay {
        Triangle(lines.map(_.split(" ").map(_.toInt).toList))
      }
      .handleErrorWith { e =>
        IO.raiseError {
          new IllegalArgumentException(s"could not construct `Triangle` instance from value: $lines",
            e)
        }
      }
}
