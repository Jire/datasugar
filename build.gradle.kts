plugins {
	kotlin("jvm") version "1.4.21"
}

group = "org.jire"
version = "0.1.0"

repositories {
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib"))
	
	implementation("net.openhft", "chronicle-core", "2.20.127.1")
	implementation("com.zaxxer", "HikariCP", "3.4.5")
	runtimeOnly("mysql", "mysql-connector-java", "8.0.22")
	implementation("it.unimi.dsi", "fastutil", "8.4.4")
}