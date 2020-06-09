package Lab5;

public class Sentence {
    private static final String punctuationSymbols = ",.!?;";
    private SentenceElement[] sentenceElements;

    public Sentence(SentenceElement[] sentenceElements) {
        this.sentenceElements = sentenceElements;
    }

    public Sentence(String sentenceString) {
        String[] sentenceElementsStrings = sentenceString.split("(?=[" + punctuationSymbols + "])|\\s");
        sentenceElements = new SentenceElement[sentenceElementsStrings.length];
        String sentenceElementString;
        for (int i = 0; i < sentenceElementsStrings.length; i++) {
            sentenceElementString = sentenceElementsStrings[i];
            sentenceElements[i] = punctuationSymbols.contains(sentenceElementString)
                    ? new Punctuation(sentenceElementString)
                    : new Word(sentenceElementString);

        }
    }



    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (int i = 0; i < sentenceElements.length; i++) {
            sentenceString.append(
                    (i != 0 && sentenceElements[i] instanceof Word ? " " : "") +
                            sentenceElements[i].toString()
            );
        }
        return sentenceString.toString();
    }



    public String task(String toString, int a, StringBuilder sorted) {
        StringBuilder Matched = new StringBuilder("");
        for (SentenceElement sentenceElement : sentenceElements) {
            if (sentenceElement instanceof Word) {
                Word word = (Word) sentenceElement;
                if (word.toString().length() == (a)) {
                    if (!sorted.toString().contains(word.toString()) && !Matched.toString().contains(word.toString())){
                        Matched.append(word.toString()+ " ") ;
                    }
                }
            }
        }
        return Matched.toString();
    }
}
