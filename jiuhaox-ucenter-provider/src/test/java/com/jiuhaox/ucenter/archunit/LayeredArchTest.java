package com.jiuhaox.ucenter.archunit;

import com.jiuhaox.test.LayeredArchRules;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;

@AnalyzeClasses(packages = "com.jiuhaox", importOptions = {ImportOption.Predefined.DoNotIncludeTests.class, ImportOption.Predefined.DoNotIncludeJars.class})
public class LayeredArchTest {
    @ArchTest
    public static final ArchTests checkLayer =  ArchTests.in(LayeredArchRules.class);
}
