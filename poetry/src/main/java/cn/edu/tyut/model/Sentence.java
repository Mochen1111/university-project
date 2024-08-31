package cn.edu.tyut.model;

public class Sentence {
    private Integer sentenceId;
    private String sentenceContent;

    @Override
    public String toString() {
        return "Sentence{" +
                "sentenceId=" + sentenceId +
                ", sentenceContent='" + sentenceContent + '\'' +
                '}';
    }

    public Integer getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    public String getSentenceContent() {
        return sentenceContent;
    }

    public void setSentenceContent(String sentenceContent) {
        this.sentenceContent = sentenceContent;
    }

    public Sentence() {
    }

    public Sentence(String sentenceContent) {
        this.sentenceContent = sentenceContent;
    }
}
