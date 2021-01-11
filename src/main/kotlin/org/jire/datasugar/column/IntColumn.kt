package org.jire.datasugar.column

import net.openhft.chronicle.core.OS
import org.jire.datasugar.Table
import kotlin.reflect.KProperty

class IntColumn(name: String, table: Table, val default: Int) : Column(4, name, table) {
	
	var autoIncrement = -1
	
	operator fun getValue(thisRef: Table, property: KProperty<*>) = OS.memory().readVolatileInt(address)
	operator fun setValue(thisRef: Table, property: KProperty<*>, value: Int) =
		OS.memory().writeVolatileInt(address, value)
	
}