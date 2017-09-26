package module

import api._
import filters.{EntityFilter, IFilter, LinkFilter, TwitterUsernameFilter}

/**
	*
	*/
object Main extends App {


	val filterList: List[IFilter] = List(
		EntityFilter,
		LinkFilter,
		TwitterUsernameFilter
	)

	val formatManager = new FormatManager(filterList)

	val moduleOneInput = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"
	val moduleTwoInput = List(
    Rule(14, 22, "Entity"),
    Rule(0, 5, "Entity"),
    Rule(55, 67, "TwitterUsername"),
    Rule(37, 54, "Link")
  )


  val result = formatManager.execute(moduleTwoInput, moduleOneInput)

	System.out.println("module one input: " + moduleOneInput)
	System.out.println("module two input: " + moduleTwoInput)
	System.out.println("module three output: " + result)
}
