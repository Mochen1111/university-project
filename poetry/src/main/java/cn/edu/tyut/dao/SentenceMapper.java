package cn.edu.tyut.dao;

import cn.edu.tyut.model.Sentence;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SentenceMapper {

    // 插入句子信息
    @Insert("INSERT INTO sentences(sentence_content) VALUES(#{sentenceContent})")
    @Options(useGeneratedKeys = true, keyProperty = "sentenceId", keyColumn = "sentence_id")
    int insertSentence(Sentence sentence);

    // 根据句子ID查询句子信息
    @Select("SELECT * FROM sentences WHERE sentence_id = #{sentenceId}")
    Sentence selectSentenceById(Integer sentenceId);

    // 查询所有句子信息
    @Select("SELECT * FROM sentences")
    List<Sentence> selectAllSentences();

    // 更新句子信息
    @Update("UPDATE sentences SET sentence_content=#{sentenceContent} WHERE sentence_id=#{sentenceId}")
    int updateSentence(Sentence sentence);

    // 删除句子信息
    @Delete("DELETE FROM sentences WHERE sentence_id = #{sentenceId}")
    int deleteSentence(Integer sentenceId);
}