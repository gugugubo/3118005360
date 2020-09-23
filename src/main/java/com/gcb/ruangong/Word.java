package com.gcb.ruangong;

import lombok.Data;

import java.util.Objects;

/**
 * @Author 古春波
 * @Description  用于分词
 * @Date 2020/9/24 0:36
 * @Version 1.0
 **/


@Data
public class Word implements Comparable<Word> {
    
    private final String name;
    
    private final String pos;

    /**
     *  权重，用于词向量分析
     */
    private Float weight;

    public Word(String name, String pos) {
        this.name = name;
        this.pos = pos;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (name != null) {
            str.append(name);
        }
        if (pos != null) {
            str.append("/").append(pos);
        }

        return str.toString();
    }


    @Override
    public int compareTo(Word o) {
        if (this == o) {
            return 0;
        }
        if (this.name == null) {
            return -1;
        }
        if (o == null) {
            return 1;
        }
        String t = o.getName();
        if (t == null) {
            return 1;
        }
        return this.name.compareTo(t);
    }

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }


}
