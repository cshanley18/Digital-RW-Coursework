
## Steps we reproduced

    scala textFromOCRScript.scala *.html >
     gregNyssSourceText2.tsv

// In atom, copied the OCR source text of 15 files into a new file, "gregNyssSourceText5to19.tsv"

    amm uniqueWordsMorphology.sc gregNyssSourceText5to19.tsv >  gregNyssMorphology5to19.tsv


   amm extractMorpheusPoS.sc gregNyssMorphology5to25.tsv > uniqueWordsParsed5to25.tsv
