import cats.effect.{IO, IOApp}
import model.Triangle
import service.MinimumPathFinderService

import scala.io.StdIn

object Main extends IOApp.Simple {

  override def run: IO[Unit] = {
    val io = for {
      lines <- IO.delay(Iterator.continually(StdIn.readLine()).takeWhile(l => l.nonEmpty && l != "EOF").toList)
      triangle <- Triangle.fromLines(lines)
      minPathSum = MinimumPathFinderService.findTriangleMinimumPath(triangle)
    } yield println(minPathSum.show)

    io.handleError{ e =>
      //error should be logged here
      println(e.getMessage)
    }
  }
}
