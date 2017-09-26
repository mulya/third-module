package module.filters

import api.Rule
import module.FilterChain

/**
	* Parent of all filters
	*/
trait IFilter {
	def formattingType: String

	def execute(input: Rule, output: String, filterChain: FilterChain): String = {
		if(input.formatting == formattingType) {
			doFilter(input, output)
		} else {
			filterChain.execute(input, output)
		}
	}

	def doFilter(input: Rule, output: String): String
}
