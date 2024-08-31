package cn.edu.tyut.service;

import cn.edu.tyut.model.Label;

import java.util.List;

public interface LabelService {
    public int addLabel(String labelName);
    public int deleteLabel(int labelId);
    public int updateLabel(Label label);
    public List<Label> getAllLabel();
    public String getLabel(int labelId);
    public List<Label> getLabelByArticleId(int articleId);
}
