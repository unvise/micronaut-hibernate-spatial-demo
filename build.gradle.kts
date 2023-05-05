plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.9"
    id("io.micronaut.test-resources") version "3.7.9"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    // jpa
    annotationProcessor("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("org.hibernate.orm:hibernate-spatial:6.1.7.Final")

    // db
    runtimeOnly("org.postgresql:postgresql")

    // db migration
    implementation("io.micronaut.flyway:micronaut-flyway")

    // deserialization
    implementation("io.micronaut:micronaut-jackson-databind")

    // validation
    annotationProcessor("io.micronaut:micronaut-http-validation")
    implementation("jakarta.annotation:jakarta.annotation-api")

    // http
    implementation("io.micronaut:micronaut-http-client")

    // logging
    runtimeOnly("ch.qos.logback:logback-classic")

    // mapping
    compileOnly("org.mapstruct:mapstruct:1.5.3.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
}

application {
    mainClass.set("com.example.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}



