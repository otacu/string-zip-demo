package com.example.string.zip.demo;

public class HuffmenNode implements Comparable<HuffmenNode> {
    //存储的字符(用Byte不用byte的原因是，对于新创建的节点是没有字符的，即data可能为null)
    Byte data;
    //权重(记录出现的次数)
    int weight;

    HuffmenNode leftNode;
    HuffmenNode rightNode;

    public HuffmenNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmenNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmenNode o) {
        return o.weight - this.weight;
    }
}
