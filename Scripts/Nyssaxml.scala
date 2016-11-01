import scala.io.Source
val xmlText = scala.io.Source.fromFile("NyssaMigneocr/njpPERIOD32101077772604_0012.html").getLines.mkString

import scala.xml._
val root = XML.loadString(xmlText)
val wordSpans = root\"body"\"div"\"span"\"span"
val textcontents = wordSpans.map(_.text).mkString(" ")
val wds = textcontents.split("\\W")
wds.distinct
