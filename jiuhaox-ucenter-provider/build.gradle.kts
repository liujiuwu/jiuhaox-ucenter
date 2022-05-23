plugins {
    java
    id("org.springframework.boot") version "3.0.0-M2"
}

apply(plugin = "io.spring.dependency-management")

group = "com.jiuhaox"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.compileJava {
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2022.0.0-M2"
extra["testcontainersVersion"] = "1.16.2"

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}"))

    implementation(project(":jiuhaox-ucenter-api"))
    implementation("com.jiuhaox:jiuhaox-spring-boot-starter:0.0.1-SNAPSHOT")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }

    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("cn.hutool:hutool-all:5.8.1")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.tngtech.archunit:archunit:0.23.1")
    testImplementation("com.tngtech.archunit:archunit-junit5:0.23.1")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}

tasks.withType<Test> {
    useJUnitPlatform()
}