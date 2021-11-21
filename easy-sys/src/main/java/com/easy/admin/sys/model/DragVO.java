package com.easy.admin.sys.model;

/**
 * 拖动
 *
 * @author TengChongChong
 * @date 2020/12/11
 */
public class DragVO {
    private String id;
    private String parent;
    private String oldParent;
    private Integer position;
    private Integer oldPosition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getOldParent() {
        return oldParent;
    }

    public void setOldParent(String oldParent) {
        this.oldParent = oldParent;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(Integer oldPosition) {
        this.oldPosition = oldPosition;
    }

    @Override
    public String toString() {
        return "DragVO{" +
                "id='" + id + '\'' +
                ", parent='" + parent + '\'' +
                ", oldParent='" + oldParent + '\'' +
                ", position=" + position +
                ", oldPosition=" + oldPosition +
                '}';
    }
}
