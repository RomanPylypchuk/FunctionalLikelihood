package blocks

case class EventProbability(p: Power, g: Power, pConj: Power, gConj: Power)

object EventProbability{
  def apply(p: Int, g: Int, pConj: Int, gConj: Int): EventProbability =
    EventProbability(Power(p), Power(g), Power(pConj), Power(gConj))
}
