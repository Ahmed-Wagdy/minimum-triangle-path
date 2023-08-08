import cats.effect.{IO, IOApp}
import model.Triangle
import service.MinimumPathFinderService

import scala.io.StdIn

object Main extends IOApp.Simple {

  override def run: IO[Unit] = {
    for {
      lines <- IO.delay(Iterator.continually(StdIn.readLine()).takeWhile(_.nonEmpty).toList)
      triangle <- Triangle.fromLines(lines)
      minPathSum = MinimumPathFinderService.findTriangleMinimumPath(triangle)
    } yield println(minPathSum.show)
  }
}
