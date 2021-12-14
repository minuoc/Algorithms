package com.algorithms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeRecursion {

    public static void main(String[] args) {
        Map<String, TNode> nodes = new HashMap<>();
        //模拟数据库存储树结构
        nodes.put("1",new TNode("1","root",1,"0"));
        nodes.put("2",new TNode("2","a",1,"1"));
        nodes.put("3",new TNode("3","b",1,"1"));
        nodes.put("4",new TNode("4","c",1,"1"));
        nodes.put("5",new TNode("5","d",1,"2"));
        nodes.put("6",new TNode("6","e",1,"2"));
        nodes.put("7",new TNode("7","f",1,"3"));
        nodes.put("8",new TNode("8","g",1,"7"));
        System.out.println("result:" + JSON.toJSONString(getNodeJson("0",nodes)));


    }

    public static JSONArray getNodeJson(String nodeId,Map<String, TNode> nodes){
        //当前node 对象
        TNode cur = nodes.get(nodeId);
        //当前层级当前点下的所有子节点
        List<TNode> childList = getChildNodes(nodeId,nodes);

        JSONArray childTree = new JSONArray();
        for (TNode node : childList){
            JSONObject o = new JSONObject();
            o.put("name",node.getName());
            o.put("type",node.getType());

            nodes.remove(nodeId);
            JSONArray childs = getNodeJson(node.getId(),nodes);
            if (!childs.isEmpty()) {
                o.put("children",childs);
            }
            childTree.fluentAdd(o);

        }
        return childTree;

    }

    public static List<TNode> getChildNodes(String nodeId, Map<String, TNode> nodes){
        List<TNode> list = new ArrayList<>();
        for (String key : nodes.keySet()){
            if (nodes.get(key).getParentId().equals(nodeId)){
                list.add(nodes.get(key));
            }
        }
        return list;
    }


}

@Data
class TNode {
    public String id;
    public String name;
    public Integer type;
    public String parentId;

    public TNode(String id, String name, Integer type, String parentId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parentId = parentId;
    }


}
