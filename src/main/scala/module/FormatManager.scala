package module

import api.Rule
import module.filters.IFilter

/**
	*
	*/
class FormatManager(formatFilterList: List[IFilter]) {

	def execute(ruleList: List[Rule], inputText: String): String = {
		val sortedRuleList = ruleList.sortBy(_.positionFrom)(Ordering.Int.reverse)
		sortedRuleList.foldLeft(inputText) { (modifiedText, rule) =>
			new FilterChain(formatFilterList).execute(rule, modifiedText)
		}
	}
}
