package syntaxdescription

import cats.implicits._

object MyPrinter {
  type Printer[α] = α => Option[String]

  val printerSyntax: Syntax[Printer] = new Syntax[Printer] {
    def pure[α](a: α): Printer[α] = { v =>
      if(v == a) Some("") else None
    }

    def token: Printer[Char] = v => Some(v.toString)

    def <*>[α, β](fa: Printer[α], fb: Printer[β]): Printer[(α, β)] = {
      case (a, b) => (fa(a),fb(b)).mapN(_ ++ _)
    }

    def map[α, β](fa: Printer[α])(iso: Iso[α, β]): Printer[β] = { v =>
      Iso.unapply(iso)(v).flatMap(fa)
    }

    def <|>[α, β](fa1: Printer[α], fa2: Printer[α]): Printer[α] = { v =>
      fa1(v) |+| fa2(v)
    }

    def empty[α]: Printer[α] = v => None
  }
  
}
