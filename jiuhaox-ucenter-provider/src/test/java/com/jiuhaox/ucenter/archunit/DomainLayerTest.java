package com.jiuhaox.ucenter.archunit;

import com.jiuhaox.test.domain.*;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@AnalyzeClasses(packages = "com.jiuhaox.ucenter.domain", importOptions = {ImportOption.Predefined.DoNotIncludeTests.class, ImportOption.Predefined.DoNotIncludeJars.class})
public class DomainLayerTest {
    @ArchTest
    static final ArchTests domainEntityRules = ArchTests.in(DomainEntityRules.class);

    @ArchTest
    static final ArchTests domainRepositoryRules = ArchTests.in(DomainRepositoryRules.class);

    @ArchTest
    static final ArchTests domeinServiceRules = ArchTests.in(DomainServiceRules.class);

    @ArchTest
    static final ArchTests domainFactoryRules = ArchTests.in(DomainFactoryRules.class);

    @ArchTest
    static final ArchTests valueObjectRules = ArchTests.in(ValueObjectRules.class);
}
