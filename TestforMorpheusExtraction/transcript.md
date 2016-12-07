
## Steps we reproduced

### Extract text contents from OCR structure

Resulting file should be in two columns, with new documents marked by lines beginning "TEXT"

    scala /vagrant/GregNyssRawText/textFromOCRScript.scala /vagrant/GregNyssRawText/*.html >   /vagrant/GregNyssRawText/gregNyssSourceText2.tsv


### Compute unique words and collect morpheus output for them

Resulting file should be in two columns.

    amm /vagrant/GregNyssRawText/uniqueWordsMorphology.sc /vagrant/GregNyssRawText/gregNyssSourceText2.tsv >  /vagrant/GregNyssRawText/gregNyssMorphology5to19.tsv



This is failing:

    amm /vagrant/GregNyssRawText/extractMorpheusPoS.sc /vagrant/GregNyssRawText/gregNyssMorphology5to19.tsv > /vagrant/GregNyssRawText/uniqueWordsParsed5to19.tsv


DIDN'T RUN THIS:

   amm /vagrant/GregNyssRawText/uniqueWordsMorphology.sc /vagrant/GregNyssRawText/gregNyssSourceText5to19.tsv > /vagrant/GregNyssRawText/gregNyssMorphology5to19.tsv
