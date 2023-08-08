package model

case class Path(sum: Int, value: List[Int]) {
  def min(that: Path): Path = {
    if (this.sum < that.sum) this else that
  }

  def show: String = s"Minimum path is: ${value.mkString(" + ")}  = $sum"
}