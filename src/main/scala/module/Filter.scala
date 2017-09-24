package module

import api.ModuleTwoRule

trait Filter {
	def formattingType: String

	def execute(input: ModuleTwoRule, output: String, filterChain: FilterChain): String = {
		if(input.formatting == formattingType) {
			doFilter(input, output)
		} else {
			filterChain.execute(input, output)
		}
	}

	def doFilter(input: ModuleTwoRule, output: String): String
}
