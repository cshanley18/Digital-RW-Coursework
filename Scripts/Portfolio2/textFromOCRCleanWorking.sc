/*
Extract text elements from OCR, throw away non-Greek strings, and dehyphenate
remaining Greek text.

One required parameter: a String identifying one file name.

*/

import scala.io.Source
import scala.xml._

@main
def textFromOcr(f: String) = {

    val xmlText = scala.io.Source.fromFile(f).getLines.mkString
    val root = XML.loadString(xmlText)
    // This is the path to word spans in the OCR output:
    val wordSpans = root\"body"\"div"\"span"\"span"
    val textContents = wordSpans.map(_.text).mkString(" ")
    val wds = textContents.split("[ ]")
    val filteredWords = wds.filterNot(_.matches("[,\\.:A-Za-z0-9�?]+\\-?")).filterNot(_.isEmpty)

    // dehyphenate:
    val filteredText = filteredWords.mkString(" ").replaceAll("- ", "")

    val sentences = filteredText.split("\\.")

    val numberedSentences = sentences.zipWithIndex
    for (s <- numberedSentences) {
      println(s._2 + "\t" + s._1 + ".\n")
    }

}
