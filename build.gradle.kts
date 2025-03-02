plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.gosnack"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.0-RC1")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")

	// Kafka
	implementation("org.springframework.kafka:spring-kafka")
	implementation("com.fasterxml.jackson.core:jackson-databind")

	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")

	testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
	testImplementation("org.mockito:mockito-core:5.3.1")
	testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
