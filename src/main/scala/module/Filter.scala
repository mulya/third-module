package module

import api.{Input, Output}

trait Filter {
	def execute(input: Input, output: Output): Output
}
