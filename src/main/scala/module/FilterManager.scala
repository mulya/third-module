package module

import api.{Input, Output}

/**
	*
	*/
class FilterManager(filterList: List[Filter]) {

	val filterChain = new FilterChain(filterList)

	def execute(input: Input, output: Output): Output = {
		filterChain.execute(input, output)
	}
}
