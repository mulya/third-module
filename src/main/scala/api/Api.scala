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

case class Output(
	text: String
)