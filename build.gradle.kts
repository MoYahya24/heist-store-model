import org.jetbrains.kotlin.builtins.StandardNames.FqNames.annotation
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.regex.Pattern.compile

plugins {
    kotlin("jvm") version "1.7.0"
    id( "org.jetbrains.kotlin.plugin.noarg") version "1.7.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.neo4j:neo4j-ogm-core:3.2.35")
    implementation("org.neo4j:neo4j-ogm-bolt-driver:3.2.35")
    implementation("org.neo4j:neo4j-ogm-bolt-native-types:3.2.35")
    implementation("org.neo4j:neo4j-ogm-bolt-native-types:3.2.35")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    testImplementation(kotlin("test"))
    implementation("io.github.serpro69:kotlin-faker:1.11.0")
    implementation("info.picocli:picocli:4.6.3")
    implementation("org.keycloak:keycloak-core:10.0.2")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-simple:1.7.36")
}

noArg {
    annotation("org.neo4j.ogm.annotation.NodeEntity")
    annotation("org.neo4j.ogm.annotation.RelationshipEntity")
}


tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}