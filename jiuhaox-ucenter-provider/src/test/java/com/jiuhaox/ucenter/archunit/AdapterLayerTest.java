package com.jiuhaox.ucenter.archunit;

import com.jiuhaox.test.adapter.InboundRules;
import com.jiuhaox.test.adapter.OutboundRules;
import com.jiuhaox.test.domain.*;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;

@AnalyzeClasses(packages = "com.jiuhaox.ucenter.adapter", importOptions = {ImportOption.Predefined.DoNotIncludeTests.class, ImportOption.Predefined.DoNotIncludeJars.class})
public class AdapterLayerTest {
    @ArchTest
    static final ArchTests inboundRules = ArchTests.in(InboundRules.class);

    @ArchTest
    static final ArchTests outboundRules = ArchTests.in(OutboundRules.class);
}
