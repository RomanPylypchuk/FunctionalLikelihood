package blocks
import scala.util.Try

case class Observation(tries: Int, found: FoN)

object Observation{
  def apply(obStr: String): Try[Observation] =
    for{
       (triesStr, fOrNStr) <- Try{
         val Array(t, fn) = obStr.split(" ")
         (t, fn)
       }
       tries <- Try(triesStr.toInt)
       fn <- FoN(fOrNStr)
    } yield Observation(tries, fn)
}
