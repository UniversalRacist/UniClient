package com.uniclient.module;

import com.uniclient.modules.ExampleModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void init() {
        modules.add(new ExampleModule());
    }

    public static List<Module> getModules() {
        return modules;
    }
}