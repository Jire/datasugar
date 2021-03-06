package org.jire.datasugar.column.provider

import org.jire.datasugar.Table
import org.jire.datasugar.column.Column
import kotlin.reflect.KProperty

class DelegatedColumnProvider<T : Column>(
	val delegatedTo: ColumnProvider<T>,
	val apply: T.(KProperty<*>) -> Unit
) : ColumnProvider<T> {
	
	override val table: Table = delegatedTo.table
	override val columnName: String? = delegatedTo.columnName
	
	override fun provideDelegate(thisRef: Table, prop: KProperty<*>) =
		delegatedTo.provideDelegate(thisRef, prop).apply { apply(prop) }
	
}