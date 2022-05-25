plugins {
    `java-library`
    `maven-publish`
    jacoco
}

group = "com.jiuhaox"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}