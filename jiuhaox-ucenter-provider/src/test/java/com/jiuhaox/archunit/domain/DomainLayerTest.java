package com.jiuhaox.archunit.domain;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@AnalyzeClasses(packages = "com.jiuhaox.ucenter.domain", importOptions = {ImportOption.Predefined.DoNotIncludeTests.class, ImportOption.Predefined.DoNotIncludeJars.class})
public class DomainLayerTest {
    @ArchTest
    public static void should_greaterThan_zero_when_test_given_packages(JavaClasses classes) {
        assertThat(classes.size(), greaterThan(0));
    }

    @ArchTest
    public static final ArchRule domain_layer_depend_on_rule = classes()
            .that().resideInAPackage("..domain..")
            .should()
            .onlyBeAccessed()
            .byAnyPackage("org.springframework.stereotype..", "..domain..")
            .allowEmptyShould(true);

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
