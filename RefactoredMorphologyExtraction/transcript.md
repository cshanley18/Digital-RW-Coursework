
## Steps


### 1. Extract text contents from OCR structure

Resulting file should be in two columns, with new documents marked by lines beginning "TEXT"

    scala textFromOCRScript.scala GregNyssRawText/*.html >   gregNyssSourceText2.tsv


### 2. Compute unique words

Read from 2-column file in previous step:

    amm uniqueWords.sc gregNyssSourceText2.tsv > uniqueWordList.text


### 3. Collect morphology results

Work on unique word list, and create a two-column output with word + list of analyses.

    amm getMorphology.sc uniqueWordList.text > morphologyResults.tsv

### 4. Extract part of speech info

    amm extractMorpheusPoS.sc morphologyResults.tsv > posInfo.tsv
