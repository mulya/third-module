package module.filters

import api.Rule

/**
	* Partial implementation of filter.
	* Convenient for pair tag implementation
	*/
trait AbstractPairTagFilter extends IFilter {
	def startTag(content: String): String
	def endTag(content: String): String

	override def doFilter(input: Rule, output: String): String = {
		val content = output.substring(input.positionFrom, input.positionTo)
		new StringBuilder(output).
			insert(input.positionTo, endTag(content)).
			insert(input.positionFrom, startTag(content)).
			toString()
	}
}
