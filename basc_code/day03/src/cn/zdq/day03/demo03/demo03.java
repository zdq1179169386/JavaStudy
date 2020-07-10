package cn.zdq.day03.demo03;


import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo03 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
