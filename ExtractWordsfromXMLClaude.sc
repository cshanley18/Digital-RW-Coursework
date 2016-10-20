import scala.io.Source
import scala.xml.XML

val lines = Source.fromFile(yourFile).getLines.mkString

val validXML = XML.loadString(lines)

val div = validXML.child(1).child(0)

val span = div \ "span" \ "span"

val words = span.map( n => n.text)
