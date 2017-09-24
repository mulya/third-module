package filters

import module.AbstractPairTagFilter

/**
	*
	*/
object EntityFilter extends AbstractPairTagFilter {

	override val formattingType = "Entity"

	override val startTag = "<strong>"
	override val endTag = "</strong>"
}
