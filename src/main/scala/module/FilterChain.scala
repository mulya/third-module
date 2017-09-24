package module

import api.{Input, Output}

class FilterChain(filterList: List[Filter]) {
	def execute(input: Input, output: Output): Output = {
		filterList.foldLeft(output) { (modifiedOutput, filter) =>
			filter.execute(input, modifiedOutput)
		}
	}
}
