plugins {
    id("org.springframework.boot") version "3.0.0-M2"
}

extra["springCloudVersion"] = "2022.0.0-M2"
val springBootVersion = "3.0.0-M2"
val lombokVersion = "1.18.24"
val mapstructVersion = "1.4.2.Final"

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}"))
    implementation(platform("com.jiuhaox:jiuhaox-common-dependencies:0.0.1-SNAPSHOT"))

    api(project(":jiuhaox-ucenter-api"))
    api("com.jiuhaox:jiuhaox-common-boot")
    implementation("cn.hutool:hutool-all")
    implementation("com.alibaba:transmittable-thread-local")
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testImplementation("org.mapstruct:mapstruct:$mapstructVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
    testImplementation("com.tngtech.archunit:archunit")
    testImplementation("com.tngtech.archunit:archunit-junit5")
    testImplementation("com.jiuhaox:jiuhaox-common-test")
}