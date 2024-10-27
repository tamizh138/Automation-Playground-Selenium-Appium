plugins {
    id("java")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation(libs.cucumber)
    implementation("org.junit.jupiter:junit-jupiter")
    implementation(libs.selenium4)
    implementation(platform("org.apache.logging.log4j:log4j-bom:2.24.1"))
    implementation("org.apache.logging.log4j:log4j-api")
    implementation("org.apache.logging.log4j:log4j-core")
    implementation("org.apache.logging.log4j:log4j-jul")
    implementation("com.browserstack:browserstack-java-sdk:1.26.2")
    implementation(libs.snakeYaml)

}

tasks.test {
    useJUnitPlatform()
    if(System.getProperty("isCloud","false").equals("true")) {
        jvmArgs("-javaagent:${project.gradle.gradleUserHomeDir}/caches/modules-2/files-2.1/com.browserstack/browserstack-java-sdk/1.26.2/cd036e1b48c621f477cf2589ce5865fa8a265206/browserstack-java-sdk-1.26.2.jar")
    }
}