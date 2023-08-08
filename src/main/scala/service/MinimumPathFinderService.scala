package service

import model.{Path, Triangle}

object MinimumPathFinderService {
  def findTriangleMinimumPath(triangle: Triangle): Path = {
    val zero = triangle.value.last.map(element => Path(element, List(element)))
    triangle.value.dropRight(1).foldRight(zero) { (acc, bottom) =>
      bottom.sliding(2).map { l2 =>
        l2.head min l2.last
      }.zip(acc).map(p => Path(p._1.sum + p._2, p._2 :: p._1.value)).toList
    }.head
  }
}
