plugins {
    java
    id("org.springframework.boot") version "3.0.0-M2" apply false
}

group = "com.jiuhaox"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2022.0.0-M2"

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
    useJUnitPlatform()
}