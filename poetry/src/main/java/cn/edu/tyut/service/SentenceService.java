package cn.edu.tyut.service;

import cn.edu.tyut.model.Sentence;

import java.util.List;

public interface SentenceService {
    public int insertSentence(Sentence sentence);
    public int deleteSentence(int id);
    public int updateSentence(Sentence sentence);
    public Sentence getSentence(int id);
    public List<Sentence> getSentences();
}
