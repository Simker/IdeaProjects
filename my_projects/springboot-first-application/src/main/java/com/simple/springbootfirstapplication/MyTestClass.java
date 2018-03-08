package com.simple.springbootfirstapplication;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.naming.event.ObjectChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构生成JSON字符串
 */
public class MyTestClass {

    public static void main(String[] args) {
        List<TreeEntityTest> list = new ArrayList<TreeEntityTest>();
        list.add(new TreeEntityTest(1,0,"目录1"));
        list.add(new TreeEntityTest(2,0,"目录1"));
        list.add(new TreeEntityTest(3,0,"目录1"));
        list.add(new TreeEntityTest(4,1,"目录1.4"));
        list.add(new TreeEntityTest(5,3,"目录3.5"));
        list.add(new TreeEntityTest(6,4,"目录4.6"));
        list.add(new TreeEntityTest(7,6,"目录6.7"));
        List<TreeEntityTest> rootList = new ArrayList<TreeEntityTest>();
        for(TreeEntityTest treeEntityTest: list){
            if (treeEntityTest.getParentId() == 0){
                treeEntityTest.setChildTreeEntityTest(getChild(treeEntityTest.getId(),list));
                rootList.add(treeEntityTest);
            }
        }
        System.out.println(JSON.toJSON(rootList));
    }
    public static List<TreeEntityTest>  getChild(int rootId,List<TreeEntityTest> rootList){
        List<TreeEntityTest> childList = new ArrayList<TreeEntityTest>();
        for(TreeEntityTest treeEntityTest: rootList){
            if(rootId == treeEntityTest.getParentId()){
                childList.add(treeEntityTest);
            }
        }
        for(TreeEntityTest childTreeEntityTest : childList){
            for(TreeEntityTest rootEntityTest : rootList){
                if(rootEntityTest.getParentId() == childTreeEntityTest.getId()){
                    //childTreeEntityTest.setChildTreeEntityTest(rootEntityTest);
                    childTreeEntityTest.setChildTreeEntityTest(getChild(childTreeEntityTest.getId(),rootList));
                }
            }
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
