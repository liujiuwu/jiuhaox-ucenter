package com.jiuhaox.archunit.outbound;

import com.jiuhaox.boot.adapter.outbound.concepts.PersistenceObject;
import com.jiuhaox.ddd.domain.concepts.Repository;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@AnalyzeClasses(packages = "com.jiuhaox.ucenter.adapter.outbound", importOptions = {ImportOption.Predefined.DoNotIncludeTests.class, ImportOption.Predefined.DoNotIncludeJars.class})
public class OutboundLayerTest {
    @ArchTest
    public static void should_greaterThan_zero_when_test_given_packages(JavaClasses classes) {
        assertThat(classes.size(), greaterThan(0));
    }

    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..repository..")
            .and().implement(Repository.class)
            .should().haveSimpleNameEndingWith("RepositoryImpl")
            .andShould().beAnnotatedWith(org.springframework.stereotype.Repository.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule base_po_rule = classes()
            .that().resideInAPackage("..repository..")
            .and().implement(PersistenceObject.class)
            .should().haveSimpleNameEndingWith("PO")
            .allowEmptyShould(true);
}
