plugins {
    `java-library`
    `maven-publish`
    jacoco
}


subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "jacoco")

    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        withSourcesJar()
    }

    tasks {
        configurations {
            compileOnly {
                extendsFrom(configurations.annotationProcessor.get())
            }
        }

        compileJava {
            options.compilerArgs.addAll(
                listOf(
                    "-Xlint:unchecked",
                    "-Xlint:deprecation",
                    "-Amapstruct.suppressGeneratorTimestamp=true",
                    "-Amapstruct.suppressGeneratorVersionInfoComment=true",
                    "-Amapstruct.verbose=true",
                    "-Amapstruct.defaultComponentModel=spring",
                )
            )
        }

        test {
            useJUnitPlatform()
            finalizedBy(jacocoTestReport)
        }

        jacocoTestReport {
            dependsOn(test)
        }

        check {
            dependsOn(
                listOf(
                    "jacocoTestReport",
                    "jacocoTestCoverageVerification",
                )
            )
        }
    }

    configure<PublishingExtension>() {
        publications {
            create<MavenPublication>("maven") {
                from(components.getByName("java"))
            }
        }
    }

    //val lombokVersion = "1.18.24"
    dependencies {
        constraints {
            //annotationProcessorCompile("org.projectlombok:lombok:$lombokVersion")
            //testAnnotationProcessorCompile("org.projectlombok:lombok:$lombokVersion")
        }
    }
}