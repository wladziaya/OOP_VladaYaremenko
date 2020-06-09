package Lab5;

public class Text
{
    private Sentence[] sentences;

    public Text(Sentence[] sentences)
    {
        this.sentences = sentences;
    }

    public Text(String textString)
    {
        String[] sentencesStrings = textString.split("(?<=[?!.]) ");
        sentences = new Sentence[sentencesStrings.length];
        for (int i = 0; i < sentencesStrings.length; i++)
        {
            sentences[i] = new Sentence(sentencesStrings[i]);
        }
    }

    @Override
    public String toString()
    {
        StringBuilder textString = new StringBuilder();
        for (int i = 0; i < sentences.length; i++)
        {
            textString.append(sentences[i].toString() + (i != sentences.length - 1 ? " " : ""));
        }
        return textString.toString();
    }




    public String findWordsGivenLength(Integer a) {
        StringBuilder sorted = new StringBuilder("");

        for (Sentence sentence : sentences)
        {
            if (sentence.toString().contains("?")){
                sorted.append(sentence.task(sentence.toString(), a, sorted));
            }
        }

        return sorted.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}
