plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.0.2"
    id("io.micronaut.test-resources") version "4.0.2"
    id("io.micronaut.aot") version "4.0.2"
}

group = "org.example"
version = "1.0"

val javaVersion: Int = 17

repositories {
    mavenLocal()
    maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("io.micronaut.openapi:micronaut-openapi")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")

    implementation("io.micronaut.cache:micronaut-cache-caffeine")
    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.sql:micronaut-jooq")
    implementation("io.micronaut.validation:micronaut-validation")
    implementation("io.swagger.core.v3:swagger-annotations")
    // added
    implementation("org.jooq:jooq-codegen:3.18.6")
    implementation("org.glavo.kala:kala-common:0.67.0")
    implementation("org.modelmapper:modelmapper:3.1.1")

    compileOnly("org.graalvm.nativeimage:svm")
    compileOnly("org.projectlombok:lombok")

    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.yaml:snakeyaml")

    testImplementation("io.micronaut:micronaut-http-client")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}


application {
    mainClass.set("org.example.mnpg.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("jetty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("io.micronaut.*")
    }
    testResources {
        additionalModules.add("jdbc-postgresql")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading.set(false)
        convertYamlToJava.set(false)
        precomputeOperations.set(true)
        cacheEnvironment.set(true)
        optimizeClassLoading.set(true)
        deduceEnvironment.set(true)
        optimizeNetty.set(true)
    }

    graalvmNative {
        binaries {
            named("main") {
                javaLauncher.set(javaToolchains.launcherFor {
                    languageVersion.set(JavaLanguageVersion.of(javaVersion))
                    vendor.set(JvmVendorSpec.matching("bellsoft"))
                })
            }
        }
    }
}
