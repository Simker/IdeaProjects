package com.simple.springbootfirstapplication;

import java.util.ArrayList;
import java.util.List;

public class TreeEntityTest {
    public TreeEntityTest(int id, int parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }


    private int id;
    private int parentId;
    private String name;
    private List<TreeEntityTest> childTreeEntityTest;
    public TreeEntityTest(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeEntityTest(int id, int parentId, String name, List<TreeEntityTest> childTreeEntityTest) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.childTreeEntityTest = childTreeEntityTest;
    }

    public List<TreeEntityTest> getChildTreeEntityTest() {
        return childTreeEntityTest;
    }

    public void setChildTreeEntityTest(List<TreeEntityTest> childTreeEntityTest) {
        if (this.childTreeEntityTest == null ){
            this.childTreeEntityTest = childTreeEntityTest;
        }else{
            for(TreeEntityTest treeEntityTest : childTreeEntityTest){
                this.childTreeEntityTest.add(treeEntityTest);
            }
        }
    }
    public void setChildTreeEntityTest(TreeEntityTest childTreeEntityTest) {
        if(this.childTreeEntityTest==null) {
            this.childTreeEntityTest = new ArrayList<TreeEntityTest>();
        }
        this.childTreeEntityTest.add(childTreeEntityTest);
    }
}
