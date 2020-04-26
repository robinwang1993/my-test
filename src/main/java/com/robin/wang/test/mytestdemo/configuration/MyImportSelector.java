package com.robin.wang.test.mytestdemo.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {


        return new String[]{"com.robin.wang.test.mytestdemo.configuration.MyConfiguration"};

    }
}
