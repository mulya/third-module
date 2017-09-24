package module

import api.ModuleTwoRule

/**
	*
	*/
class FilterManager(filterList: List[IFilter]) {

	def execute(input: ModuleTwoRule, output: String): String = {
		new FilterChain(filterList).execute(input, output)
	}
}
