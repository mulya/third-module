package module

import api.ModuleTwoRule

trait AbstractPairTagFilter extends IFilter {
	def startTag: String
	def endTag: String

	override def doFilter(input: ModuleTwoRule, output: String): String = {
		new StringBuilder(output).
			insert(input.positionTo, endTag).
			insert(input.positionFrom, startTag).
			toString()
	}
}
