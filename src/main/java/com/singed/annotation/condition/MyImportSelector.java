package com.singed.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @Author : Singed
 * @Date : 2021/9/7 23:18
 */
public class MyImportSelector implements ImportSelector {
    //返回值就是导入到容器中的组件全类名
    //AnnotationMetadata 当前标注@Import注解类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.singed.annotation.beans.Blue","com.singed.annotation.beans.Yellow"};
    }
}
