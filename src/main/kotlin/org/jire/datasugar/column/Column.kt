package org.jire.datasugar.column

import org.jire.datasugar.Datasugar
import org.jire.datasugar.Table

abstract class Column(
	val size: Long,
	override val name: String,
	val table: Table
) : Datasugar {
	
	@Volatile
	internal var address: Long = 0L
	
	init {
		address = table.nextColumnAddress()
		table.offset += size
	}
	
}