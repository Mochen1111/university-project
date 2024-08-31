package cn.edu.tyut.model;

public class Label {
    private Integer labelId;
    private String labelName;

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                '}';
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Label() {
    }

    public Label(String labelName) {
        this.labelName = labelName;
    }
}
