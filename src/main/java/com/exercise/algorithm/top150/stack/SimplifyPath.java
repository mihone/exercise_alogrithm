package com.exercise.algorithm.top150.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 71. 简化路径
*  @author mihone
*  @since 2024/12/10 0:02
*/
public class SimplifyPath {
    public static void main(String[] args) {
        String[] split = "//a/".split("/");
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/../"));

    }
    public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }
        if (path.isEmpty()) {
            return "";
        }
        String[] split = path.split("/");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (!"".equals(split[i])) {
                list.add("/"+split[i]);
            }
            if (!list.isEmpty()) {
                String s = list.get(list.size() - 1);
                if ("/.".equals(s)) {
                    list.remove(list.size() - 1);
                } else if ("/..".equals(s)) {
                    list.remove(list.size() - 1);
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        String join = String.join("", list);
        return join.isEmpty()?"/":join;

    }


}
