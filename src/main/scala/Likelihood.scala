import blocks._
import cats.implicits._
import Algebra.EventProbabilitySemigroup

object Likelihood {

  val observationProbability: Observation => EventProbability = {
    case Observation(k, F) =>
      EventProbability(Power(1), Power(0), Power(k-1), Power(k-1))
    case Observation(k, N) =>
      EventProbability(Power(0), Power(1), Power(k), Power(k-1))
  }

  val likelihood: List[Observation] => EventProbability =
    obs =>
      obs.map(observationProbability).reduceLeft(_ |+| _)

  val params: EventProbability => (Double, Double) = {
    case EventProbability(Power(a), Power(b), Power(c), Power(d)) =>
      (a.toDouble / (a + c), b.toDouble / (b + d))
  }
}
