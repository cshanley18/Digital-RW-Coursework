Digital Writing Final Presentation
---
**Background**

- Gregory of Nyssa: Theologian, philosopher, rhetorician
	- Dialogues, sermons, treatises, biographies
- Stylistic patterns across this corpus

---
**The Pattern**

	ὅσα περὶ τὴν θείαν καθοραται φύσιν
	
- Basic form: verb-noun
- How common is this across Gregory's corpus?  What different forms can it take?

---
**Preparing Texts**'

- Begin from 700 raw OCR files

	! (Digital-RW-Coursework/DigitalRWPresentation/rawOCRImage.png.png)
- Extract the XML text from the OCR structure and parse

---

- Aligned Text using Parts of Speech, not lemmata

	! [Digital-RW-Coursework/DigitalRWPresentation/alignedPoS100.png.png]
- Bom Character and contaminated data
	 

---
**Methods**

- Plan: use n-grams and the sliding function to observe each occurrence of the noun-verb pair, and then count backwards from that pair to catch any article or adjective
