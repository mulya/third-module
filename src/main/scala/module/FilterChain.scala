package module

import api.ModuleTwoRule

class FilterChain(filterList: List[Filter]) {

	val iterator = filterList.iterator

	def execute(input: ModuleTwoRule, output: String): String = {
		if(iterator.hasNext) {
			iterator.next().execute(input, output, this)
		} else {
			output
		}
	}
}
