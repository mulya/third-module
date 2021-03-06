package module.filters

import api.Rule

/**
	*
	*/
object TwitterUsernameFilter extends IFilter
{
	override val formattingType = "TwitterUsername"

  def doFilter(input: Rule, output: String): String = {
    val content = output.substring(input.positionFrom, input.positionTo)
    if(content.startsWith("@")) {
      val name = content.substring(1)
      new StringBuilder(output).
        delete(input.positionFrom, input.positionTo).
        insert(input.positionFrom, s"""@ <a href=”http://twitter.com/$name”>$name</a>""").
        toString()
    } else {
      throw new IllegalArgumentException("Wrong input, content must start with @")
    }
  }
}
