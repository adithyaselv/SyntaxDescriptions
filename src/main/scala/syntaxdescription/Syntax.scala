package syntaxdescription

import scala.language.higherKinds

trait Syntax[δ[_]] extends IsoFunctor[δ] with ProductFunctor[δ] with Alternative[δ] {
  def pure[α](a: α): δ[α]
  def token: δ[Char]
}