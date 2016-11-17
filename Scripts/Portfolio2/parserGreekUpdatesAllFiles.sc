
import scala.io.Source
import scala.xml._

@main
  def Nyssaxml(file: String){

    val fileNames = scala.io.Source.fromFile(file).getLines

    for (f <- fileNames.toVector){
    println("EXAMINE NEW FILE: " + f)

    val xmlText = scala.io.Source.fromFile(f).getLines.mkString

    val root = XML.loadString(xmlText)

    val wordSpans = root\"body"\"div"\"span"\"span"

    val textContents = wordSpans.map(_.text).mkString(" ")

    val wds = textContents.split(" ")

    val filteredWords = wds.filterNot(_.matches("[A-Za-z0-9]+"))

    val uniqueWords = filteredWords.distinct

    val sortedWords = uniqueWords.toVector.sorted

    val parsedResults = sortedWords.map( w => (w,parse(w)) )

    for (p <- parsedResults) {

      println(p._1 + "\t" + p._2)
    }
  }
}

def  getMorphReply(request: String) : String = {
  var reply : String = ""
  try {
    reply = scala.io.Source.fromURL(request).mkString.replaceAll("\n"," ")
  } catch {
    case _ => reply = "Error from parsing service."
  }
  reply
}


/** Gets a reply from the perseus morphology service
* for a given word.
*/
def parse (s: String): String = {
  val baseUrl = "https://services.perseids.org/bsp/morphologyservice/analysis/word?lang=grc&engine=morpheusgrc&word="
  val request = baseUrl + s
  getMorphReply(request)
}