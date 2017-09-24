package api

case class ModuleOneInput(
	text: String
)

case class ModuleTwoRule (
	positionFrom: Int,
	positionTo: Int,
	formatting: Formatting
)

case class ModuleTwoInput(
	list: List[ModuleTwoRule]
)

trait Formatting
case object Entity extends Formatting
case object TwitterUsername extends Formatting
case object Link extends Formatting

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