package cn.edu.tyut.service;

import cn.edu.tyut.dao.SentenceMapper;
import cn.edu.tyut.model.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SentenceServiceImpl implements SentenceService {
    @Autowired
    private SentenceMapper sentenceMapper;

    // 插入句子信息
    @Override
    public int insertSentence(Sentence sentence) {
        int flag = sentenceMapper.insertSentence(sentence);
        return flag;
    }

    // 删除句子信息
    @Override
    public int deleteSentence(int id) {
        int flag = sentenceMapper.deleteSentence(id);
        return flag;
    }

    // 更新句子信息
    @Override
    public int updateSentence(Sentence sentence) {
        int flag = sentenceMapper.updateSentence(sentence);
        return flag;
    }

    // 根据句子ID查询句子信息
    @Override
    public Sentence getSentence(int id) {
        Sentence sentence = sentenceMapper.selectSentenceById(id);
        return sentence;
    }

    // 查询所有句子信息
    @Override
    public List<Sentence> getSentences() {
        List<Sentence> sentences = sentenceMapper.selectAllSentences();
        if (sentences != null) {
            return sentences;
        }else {
            return Collections.emptyList();
        }
    }
}
