package com.jmc.springshell.cmd;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.Objects;

// 定义为Shell组件
@ShellComponent
// 创建命令集，定义help中其名称为: Hello Command
public class HelloCommand {
    // 创建命令，定义其含义
    @ShellMethod("Hello here!")
    // 定义命令名为hello，2个参数包含定义（调用help可见）
    public List<String> hello(@ShellOption(help = "名字") String name,
                              @ShellOption(help = "在哪里") String addr) {
        // 返回对象会直接打印出来
        return List.of("Hello", name, "In", addr, "!");
    }

    // 定义命令名称为echoList（默认是echo-list），指令前缀是-（默认是--）
    @ShellMethod(value = "Echo List.", key = "echoList", prefix = "-")
    // 定义list参数名称为-l和--LIST，类型为int[]（不能用List<>，不适配）
    public void echoList(@ShellOption({"-l", "--LIST"}) int[] list) {
        System.out.println("size: " + list.length);
        for (var t : list) {
            System.out.println("element: " + t);
        }
    }
}
