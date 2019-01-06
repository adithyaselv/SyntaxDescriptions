package syntaxdescription

final class Iso[α, β](val f: α => Option[β], val g: β => Option[α])

object Iso {
  def inverse[α, β](iso: Iso[α, β]): Iso[β, α] = new Iso(iso.g, iso.f)
  def apply[α, β](iso: Iso[α, β]): α => Option[β]  = iso.f
  def unapply[α, β](iso: Iso[α, β]): β => Option[α] = apply(inverse(iso))
}
