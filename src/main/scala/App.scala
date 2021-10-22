import scala.io.Source
import scala.util.{Try, Using}
import blocks.Observation
import cats.implicits._
import Likelihood.{params, likelihood}

object App extends App{

  val parseObservation: String => Try[List[Observation]] =
    filename =>
      for {
        strObs <- Using(Source.fromFile(filename)){ reader => reader.getLines().toList}
        obs <- strObs.map(x => Observation(x)).sequence
      } yield obs

  val lld = parseObservation("/tmp/sample_2_4.txt").map(params compose likelihood)
  println(lld)
}
