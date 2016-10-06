import io.Source
val lines = Source.fromFile("cutcaesar.txt").getLines.toVector
val letters = lines.mkString
val words = letters.split("\\W+").filterNot(_.isEmpty)
val grouped = words.groupBy (w => w)
val freqs = grouped.map { case (k,v) => (k,v.size) }
val ordered = freqs.toSeq
val sorted = ordered.sortBy(_._2)
for (wd <- sorted ) { println(wd) }
println("Read " + lines.size + "sections.")
println("Read " + letters.size + "characters.")
println("Read " + words.size + "words.")
println("Read " + grouped.size + "unique words.")
