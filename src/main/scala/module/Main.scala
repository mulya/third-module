package module

import api._
import filters.{EntityFilter, LinkFilter, TwitterUsernameFilter}

/**
	*
	*/
object Main extends App {
	val filterList: List[Filter] = List(
		EntityFilter,
		LinkFilter,
		TwitterUsernameFilter
	)

	val filterManager = new FilterManager(filterList)

	val input = Input(
			"Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile",
			List(
				ModuleTwoRule(14, 22, Entity),
				ModuleTwoRule(0, 5, Entity),
				ModuleTwoRule(55, 67, TwitterUsername),
				ModuleTwoRule(37, 54, Link)
			)
	)

	val result = filterManager.execute(input, Output(input.moduleOneInput.text))

	System.out.println("input: " + input)
	System.out.println("output: " + result)
}
