package com.jiuhaox.archunit.domain;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ddd.domain.concepts.Entity;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainEntityRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..entity..")
            .should().implement(Entity.class)
            .orShould().implement(AggregateRoot.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule in_package_rule = classes()
            .that().implement(Entity.class)
            .or().implement(AggregateRoot.class)
            .should().resideInAPackage("..model..")
            .allowEmptyShould(true);
}
