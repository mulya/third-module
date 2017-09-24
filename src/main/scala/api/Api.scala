package api

case class ModuleOneInput(
	text: String
)

case class ModuleTwoRule (
	positionFrom: Int,
	positionTo: Int,
	formatting: String
)

case class ModuleTwoInput(
	list: List[ModuleTwoRule]
)

case class Input(
	moduleOneInput: ModuleOneInput,
	moduleTwoInput: ModuleTwoInput
)

object Input {
	def apply(text: String, list: List[ModuleTwoRule]): Input =
		new Input(ModuleOneInput(text), ModuleTwoInput(list))
}

case class Output(
	text: String
)