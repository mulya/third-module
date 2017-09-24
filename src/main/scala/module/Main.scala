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

	val moduleOneInput = ModuleOneInput("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile")
	val moduleTwoInput = ModuleTwoInput(List(
			ModuleTwoRule(14, 22, "Entity"),
			ModuleTwoRule(0, 5, "Entity"),
			ModuleTwoRule(55, 67, "TwitterUsername"),
			ModuleTwoRule(37, 54, "Link")
		)
	)

	val result = moduleTwoInput.list.foldRight(moduleOneInput.text){ (rule, modifiedOutput) =>
		filterManager.execute(rule, modifiedOutput)
	}


	System.out.println("module one input: " + moduleOneInput)
	System.out.println("module two input: " + moduleTwoInput)
	System.out.println("module three output: " + result)
}
