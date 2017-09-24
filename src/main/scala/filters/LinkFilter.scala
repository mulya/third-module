package filters

import module.AbstractPairTagFilter

/**
	*
	*/
object LinkFilter extends AbstractPairTagFilter {
	override val formattingType = "Link"

	override def startTag(content: String) = s"""<a href="$content">"""
	override def endTag(content: String) = " </a>"
}
