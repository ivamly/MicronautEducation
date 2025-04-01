package com.ivamly.architecture;

import com.ivamly.Application;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packagesOf = Application.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

    @ArchTest
    static final ArchRule servicesMustResideInServicePackage =
            classes().that().haveNameMatching(".*Service").should().resideInAPackage("..service..")
                    .as("Services should reside in a package '..service..'");

    @ArchTest
    static final ArchRule controllersMustResideInControllerPackage =
            classes().that().haveNameMatching(".*Controller").should().resideInAPackage("..controller..")
                    .as("Controllers should reside in a package '..controller..'");

    @ArchTest
    static final ArchRule repositoriesMustResideInRepositoryPackage =
            classes().that().haveNameMatching(".*Repository").should().resideInAPackage("..repository..")
                    .as("Repositories should reside in a package '..repository..'");

    @ArchTest
    static final ArchRule layeredArchitecture = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("Controller").definedBy("..controller..")
            .layer("Service").definedBy("..service..")
            .layer("Repository").definedBy("..repository..")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");
}
