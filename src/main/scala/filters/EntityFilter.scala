package filters

import module.AbstractPairTagFilter

/**
	*
	*/
object EntityFilter extends AbstractPairTagFilter {

	override val formattingType = "Entity"

	override def startTag(content: String) = "<strong>"
	override def endTag(content: String) = "</strong>"
}
