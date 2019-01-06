package syntaxdescription

import scala.language.higherKinds

trait IsoFunctor[F[_]] {
  def map[α, β](fa: F[α])(iso: Iso[α, β]): F[β]
}

trait ProductFunctor[F[_]]{
  def <*>[α, β](fa: F[α], fb: F[β]): F[(α,β)]
}

trait Alternative[F[_]]{
  def <|>[α, β](fa1: F[α], fa2: F[α]): F[α]
  def empty[α]: F[α]
}