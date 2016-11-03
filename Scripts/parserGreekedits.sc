
import scala.io.Source
import scala.xml._

@main
  def Nyssaxml(f: String){

    val xmlText = scala.io.Source.fromFile(f).getLines.mkString

    val root = XML.loadString(xmlText)

    val wordSpans = root\"body"\"div"\"span"\"span"

    val textContents = wordSpans.map(_.text).mkString(" ")

    val wds = textContents.split(" ")

    val uniqueWords = wds.distinct

    val parsedResults = uniqueWords.map( w => (w,parse(w)) )

    for (p <- parsedResults) {

      println(p)

}
  }

def lemmaForEntry(nseq:  NodeSeq) = {
  if (nseq.size > 0) {
    nseq(0).text
  } else ""
}

def uriForEntry(nseq:  NodeSeq) = {
  if (nseq.size > 0) {
    nseq(0).text.replaceAll("http://data.perseus.org/collections/urn:cite:perseus:grclexent.", "")
  } else ""
}

def formatEntry(e: Elem) = {
  val uriList = e \ "@uri"
  val headList = e \\ "hdwd"
  val lemma = lemmaForEntry(headList)
  val uri = uriForEntry(uriList)
  uri + "_" + lemma
}

def parse (s : String) = {
  val baseUrl = "https://services.perseids.org/bsp/morphologyservice/analysis/word?lang=grc&engine=morpheusgrc&word="
  val query = baseUrl + s
  val morphReply = scala.io.Source.fromURL(query).mkString
  val root = XML.loadString(morphReply)
  val entries = root \\ "entry"

  val lexent = entries.map ( e => e match {
    case el: Elem => formatEntry(el)
    case _ => ""
  })
  lexent

}
