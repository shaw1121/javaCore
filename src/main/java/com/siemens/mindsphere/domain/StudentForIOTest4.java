package com.siemens.mindsphere.domain;

import java.util.Objects;

/**
 * @author Zhang Xiao
 * @date 9/14/2018 22:34
 */
public class StudentForIOTest4 implements Comparable<StudentForIOTest4>{

    /**
     * 姓名，语文分数，数学分数，英语分数，总分
     * 将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序
     * 并将姓名按总分从高到低的顺序写入文件中。
     */
    private String name;
    private int chinese;
    private int math;
    private int en;
    private int sum;

    public StudentForIOTest4() {
        super();
    }

    public StudentForIOTest4(String name, int chinese, int math, int en) {
        super();
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.en = en;
        this.sum = chinese + math + en;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public String getName() {
        return name;
    }

    public int getChinese() {
        return chinese;
    }

    public int getMath() {
        return math;
    }

    public int getEn() {
        return en;
    }

    public int getSum() {
        return chinese + math + en;
    }

    @Override
    public String toString() {
        return "StudentForIOTest4{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentForIOTest4 that = (StudentForIOTest4) o;
        return sum == that.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum);
    }

    @Override
    public int compareTo(StudentForIOTest4 s) {
        int temp = this.sum - s.sum;
        return temp==0 ? this.name.compareTo(s.name) : temp;
    }
}
