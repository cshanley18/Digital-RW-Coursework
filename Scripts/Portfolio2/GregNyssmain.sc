import scala.io.Source

@main
  def Nyssaxml(f: String){


val xmlText = scala.io.Source.fromFile(f).getLines.mkString

import scala.xml._

val root = XML.loadString(xmlText)

val wordSpans = root\"body"\"div"\"span"\"span"

val textContents = wordSpans.map(_.text).mkString(" ")

val wds = textContents.split(" ")

val uniqueWords = wds.distinct

for (u <- uniqueWords) {

println(u)

}
  }
