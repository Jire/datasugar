# datasugar

_high-performance persisted data - made sweet - for the JVM_

<img src="https://i.imgur.com/NQygZwr.png" />

[![CI Status](https://github.com/Jire/datasugar/workflows/ci/badge.svg)](https://github.com/Jire/datasugar/actions?query=workflow%3Aci)
[![License](https://img.shields.io/github/license/Jire/datasugar.svg)](https://github.com/Jire/datasugar/blob/master/LICENSE.txt)

`datasugar` is a sweet & simple library that can acts as a layer between your primary storage and applications.
Underneath the hood, `datasugar` uses memory-mapped files (virtual memory) to provide a persisted data map with
system-memory level write/read times. All data is persisted to disk by your kernel, and is safe in the event something
goes wrong, such as an application crash. A single `datasugar` directory can be safely used concurrently by a multitude
of processes on the same machine.

---

### Define your database

```kotlin
object Server : Database("server") {
	object Players : Table("players") {
		val uid by autoInc.int().primary()
		var username by string(50).unique()
		var x by short()
		var y by short()
		var z by byte()
	}
}
```

### Then read from it easily

```kotlin
Server.Players(123) {
	println("uid=$uid, username=$username, position=($x, $y, $z)")
}
```

### And write to it easily

```kotlin
Server.Players(123) {
	username = "jire"
	x = 3222
	y = 3222
}
```

### That's all, folks!

The final step is setup your `Database` by specifying a directory:

```kotlin
Server.setup("data/server")
```

### SQL synchronization

Synchronizing your `Database` with an SQL database is sweet & simple:

```kotlin
Server.setup("data/server") {
	postgresql { // or "mysql5", "mysql8"
		host = "localhost"
		port = 3306
		username = "root"
		password = "sweetdata"
	}
}
```