plugins {
    id("java")
    id("io.freefair.lombok") version "8.1.0"
}

val flinkVersion: String by project
val kafkaVersion: String by project
val loggerVersion: String by project
val junitVersion: String by project

group = "hduong"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
    implementation("org.apache.kafka:kafka-clients:$kafkaVersion")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:1.7.32")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:1.7.32")

    // Generate Fake Data
    implementation("net.datafaker:datafaker:2.0.1")

    // Postgresql
    implementation("org.postgresql:postgresql:42.6.0")

    implementation("org.apache.flink:flink-core:$flinkVersion")
    implementation("org.apache.flink:flink-connector-kafka:$flinkVersion")
    implementation("org.apache.flink:flink-streaming-java:$flinkVersion")
    implementation("org.apache.flink:flink-table-api-java-bridge:$flinkVersion")
    implementation("org.apache.flink:flink-clients:$flinkVersion")
    implementation("org.apache.kafka:kafka-clients:$kafkaVersion")
    implementation("org.apache.flink:flink-avro:$flinkVersion")
    implementation("org.apache.flink:flink-connector-jdbc:3.1.1-1.17")
    implementation("org.apache.logging.log4j:log4j-api:$loggerVersion")
    implementation("org.apache.logging.log4j:log4j-core:$loggerVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$loggerVersion")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.projectlombok:lombok:1.18.26")

    // Config
    implementation("com.typesafe:config:1.3.2")

    testImplementation("junit:junit:$junitVersion")
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.apache.flink:flink-test-utils:$flinkVersion")
}

tasks.test {
    useJUnitPlatform()
}