# datasugar

_high-performance persisted data - made sweet - for the JVM_

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