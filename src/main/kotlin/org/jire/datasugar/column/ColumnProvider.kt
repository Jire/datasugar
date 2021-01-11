package org.jire.datasugar.column

import org.jire.datasugar.Table
import kotlin.reflect.KProperty

interface ColumnProvider<T : Column> {
	
	val table: Table
	val columnName: String?
	
	operator fun provideDelegate(
		thisRef: Table,
		prop: KProperty<*>
	): T
	
	fun delegatedTo(apply: T.(KProperty<*>) -> Unit) = DelegatedColumnProvider(this, apply)
	
}