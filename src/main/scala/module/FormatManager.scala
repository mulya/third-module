package module

import api.ModuleTwoRule

/**
	*
	*/
class FormatManager(formatFilterList: List[IFilter]) {

	def execute(ruleList: List[ModuleTwoRule], inputText: String): String = {
		val sortedRuleList = ruleList.sortBy(_.positionFrom)(Ordering.Int.reverse)
		sortedRuleList.foldLeft(inputText) { (modifiedText, rule) =>
			new FilterChain(formatFilterList).execute(rule, modifiedText)
		}
	}
}
