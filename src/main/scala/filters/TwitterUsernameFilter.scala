package filters

import module.AbstractPairTagFilter

/**
	*
	*/
object TwitterUsernameFilter extends AbstractPairTagFilter
{
	override val formattingType = "TwitterUsername"

	override val startTag = "<a>"
	override val endTag = "</a>"
}
