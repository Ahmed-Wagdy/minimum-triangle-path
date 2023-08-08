import model.Triangle
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import service.MinimumPathFinderService

import scala.io.Source

class MinimumPathFinderServiceSpec extends AnyFlatSpec with should.Matchers {
  import cats.effect.unsafe.implicits.global
  "A Triangle's minimum Path" should " be the path that has the minimum sum" in {
    val triangle = Triangle(List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9)))
    val expectedResult = "Minimal path is: 7 + 6 + 3 + 2 = 18"
    MinimumPathFinderService.findTriangleMinimumPath(triangle).show shouldBe expectedResult
  }

  "A Triangle's minimum Path for data_small.txt" should " be giving the correct result" in {

    val resourceName = "data_small.txt"
    val bs = Source.fromResource(resourceName)
    val lines = bs.getLines().toList
    val triangle = Triangle.fromLines(lines)
    bs.close()
    val expectedResult = 50
    MinimumPathFinderService.findTriangleMinimumPath(triangle.unsafeRunSync()).sum shouldBe expectedResult
  }


  "A Triangle's minimum Path for data_big.txt" should " be giving the correct result" in {

    val resourceName = "data_big.txt"
    val bs = Source.fromResource(resourceName)
    val lines = bs.getLines().toList
    val triangle = Triangle.fromLines(lines)
    bs.close()
    val expectedResult = 2000
    MinimumPathFinderService.findTriangleMinimumPath(triangle.unsafeRunSync()).sum shouldBe expectedResult
  }

  "Triangle data" should  " only be constructed from correct format" in {

    val resourceName = "incorrect_format.txt"
    val bs = Source.fromResource(resourceName)
    val lines = bs.getLines().toList
    val triangle = Triangle.fromLines(lines)
    bs.close()
    an [IllegalArgumentException] should be thrownBy(MinimumPathFinderService.findTriangleMinimumPath(triangle.unsafeRunSync()))
  }


  "Triangle data" should " represent a complete triangle" in {

    val resourceName = "incomplete_triangle.txt"
    val bs = Source.fromResource(resourceName)
    val lines = bs.getLines().toList
    val triangle = Triangle.fromLines(lines)
    bs.close()
    an[IllegalArgumentException] should be thrownBy (MinimumPathFinderService.findTriangleMinimumPath(triangle.unsafeRunSync()))
  }
}
