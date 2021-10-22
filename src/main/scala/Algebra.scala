import blocks.{Power, EventProbability}
import cats.{Group, Semigroup}
import cats.implicits._

object Algebra {

  implicit object PowerGroup extends Group[Power]{
    def empty: Power = Power(0)
    def combine(x: Power, y: Power): Power = Power(x.n + y.n)
    def inverse(a: Power): Power = a.copy(n = -a.n)
  }

  implicit object EventProbabilityMonoid extends Semigroup[EventProbability] {
    def combine(x: EventProbability, y: EventProbability): EventProbability =
      EventProbability(
        x.p |+| y.p, x.g |+| y.g, x.pConj |+| y.pConj, x.gConj |+| y.gConj
      )
  }

}
