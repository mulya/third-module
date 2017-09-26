package module

import api.Rule
import module.filters.IFilter

class FilterChain(filterList: List[IFilter]) {

	val iterator = filterList.iterator

	def execute(input: Rule, output: String): String = {
		if(iterator.hasNext) {
			iterator.next().execute(input, output, this)
		} else {
			output
		}
	}
}
