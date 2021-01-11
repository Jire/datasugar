package org.jire.datasugar

import org.jire.datasugar.column.Column
import org.jire.datasugar.column.provider.IntColumnProvider

abstract class Table(override val name: String) : Datasugar {
	
	companion object {
		const val NIL_ADDRESS = -1L
		const val NIL_KEY = -1L
	}
	
	internal var address = NIL_ADDRESS
	internal var offset = 0L
	
	internal fun nextColumnAddress() = address + offset
	
	@Volatile
	internal var key = NIL_KEY
	
	internal lateinit var primaryKey: Column
	
	fun int(columnName: String?, default: Int = 0) = IntColumnProvider(this, columnName, default)
	fun int(default: Int = 0) = int(null, default)
	
}