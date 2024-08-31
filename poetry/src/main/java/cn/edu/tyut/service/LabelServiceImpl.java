package cn.edu.tyut.service;

import cn.edu.tyut.dao.LabelArticleMapper;
import cn.edu.tyut.dao.LabelMapper;
import cn.edu.tyut.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private LabelArticleMapper labelArticleMapper;

    // 添加标签
    @Override
    public int addLabel(String labelName) {
        Label label = new Label(labelName);
        // 查询标签是否存在
        Label label1 = labelMapper.selectLabelByName(labelName);
        int flag = 0;
        if (label1 == null) {
            flag = labelMapper.insertLabel(label);
        }
        if (flag == 1) {
            return 1;
        }else {
            return 0;
        }
    }

    // 删除标签
    @Override
    public int deleteLabel(int labelId) {
        int i = labelMapper.deleteLabel(labelId);
        return i;
    }

    // 更新标签
    @Override
    public int updateLabel(Label label) {
        int i = labelMapper.updateLabel(label);
        return i;
    }

    // 查询所有标签
    @Override
    public List<Label> getAllLabel() {
        // 查询所有标签信息
        List<Label> labels = labelMapper.selectAllLabels();
        if (labels == null) {
            return Collections.emptyList();
        }else {
            return labels;
        }
    }

    // 根据标签ID查询标签信息
    @Override
    public String getLabel(int labelId) {
        Label label = labelMapper.selectLabelById(labelId);
        if (label == null) {
            return "";
        }else {
            return label.getLabelName();
        }
    }

    // 根据文章ID查询标签信息
    @Override
    public List<Label> getLabelByArticleId(int articleId) {
        // 根据文章ID查询关联的标签ID列表
        List<Integer> labelIds = labelArticleMapper.selectLabelIdsByArticleId(articleId);
        if (labelIds == null) {
            return Collections.emptyList();
        }else {
            // 根据标签ID查询标签信息
            List<Label> labels = new ArrayList<>();
            for (Integer labelId : labelIds) {
                Label label = labelMapper.selectLabelById(labelId);
                labels.add(label);
            }
            return labels;
        }
    }
}
