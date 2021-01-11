package org.jire.datasugar.column.provider

import org.jire.datasugar.Table
import org.jire.datasugar.column.IntColumn
import kotlin.reflect.KProperty

open class IntColumnProvider(
	override val table: Table,
	override val columnName: String?,
	val default: Int
) : ColumnProvider<IntColumn> {
	
	override fun provideDelegate(thisRef: Table, prop: KProperty<*>) =
		IntColumn(columnName ?: prop.name, thisRef, default)
	
	fun autoInc(startAt: Int = 0) = delegatedTo { autoIncrement = startAt }
	
}