package cn.edu.tyut.dao;

import cn.edu.tyut.model.Label;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LabelMapper {
    // 插入标签信息
    @Insert("INSERT INTO labels(label_name) VALUES(#{labelName})")
    @Options(useGeneratedKeys = true, keyProperty = "labelId", keyColumn = "label_id")
    int insertLabel(Label label);

    // 根据标签ID查询标签信息
    @Select("SELECT * FROM labels WHERE label_id = #{labelId}")
    Label selectLabelById(Integer labelId);

    // 查询所有标签信息
    @Select("SELECT * FROM labels")
    List<Label> selectAllLabels();

    // 根据标签名查询标签信息
    @Select("SELECT * FROM labels WHERE label_name = #{labelName}")
    Label selectLabelByName(String labelName);

    // 更新标签信息
    @Update("UPDATE labels SET label_name=#{labelName} WHERE label_id=#{labelId}")
    int updateLabel(Label label);

    // 删除标签信息
    @Delete("DELETE FROM labels WHERE label_id = #{labelId}")
    int deleteLabel(Integer labelId);
}
