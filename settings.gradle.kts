pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }
}

rootProject.name = "jiuhaox-ucenter"
include("jiuhaox-ucenter-api")
include("jiuhaox-ucenter-provider")
