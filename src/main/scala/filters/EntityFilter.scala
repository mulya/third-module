package filters

import api.{Input, ModuleTwoInput, Output}
import module.Filter

/**
	*
	*/
object EntityFilter extends Filter {

	def formattingType = "entity"

	def startTag = "<strong>"
	def endTag = "</strong>"

	override def execute(input: Input, previousOutput: Output): Output = {
		val (thisRules, otherRules) = input.moduleTwoInput.list.span(_.formatting == formattingType)

		thisRules.foldRight(previousOutput.text){ (rule, modifiedText) =>
				new StringBuilder(modifiedText).
					insert(rule.positionTo, "</strong>").
					insert(rule.positionFrom, "<strong>").
					toString()
		}

//			map{
//			case ModuleTwoRule(from, to, formatting: Entity) =>
//				new StringBuilder(output.text).
//					insert(to, "</strong>").
//					insert(from, "<strong>").
//					toString()
//		}
//		output //TODO

	}
}
