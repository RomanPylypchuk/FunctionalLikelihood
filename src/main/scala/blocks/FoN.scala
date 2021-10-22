package blocks
import scala.util.{Failure, Success, Try}

sealed trait FoN

case object F extends FoN
case object N extends FoN

object FoN {
  def apply(fOrN: String): Try[FoN] = fOrN match {
    case "F" => Success(F)
    case "N" => Success(N)
    case _ => Failure(new Exception("Error parsing F or N"))
  }
}
