package filters

import module.AbstractPairTagFilter

/**
	*
	*/
object LinkFilter extends AbstractPairTagFilter {
	override val formattingType = "Link"

	override val startTag = "<a>"
	override val endTag = "</a>"
}
