import api._
import filters.{EntityFilter, LinkFilter, TwitterUsernameFilter}
import module.{Filter, FilterManager}
import org.specs2.Specification

class ThirdModuleSpec extends Specification { def is = s2"""

 Third module should
   test one                                         $test1
                                                                 """

  def test1 = {
    val filterList: List[Filter] = List(
      EntityFilter,
      LinkFilter,
      TwitterUsernameFilter
    )

    val filterManager = new FilterManager(filterList)

    val input = Input(
      ModuleOneInput(
        "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"
      ),
      ModuleTwoInput(
        List(
          ModuleTwoRule(14, 22, Entity),
          ModuleTwoRule(0, 5, Entity),
          ModuleTwoRule(55, 67, TwitterUsername),
          ModuleTwoRule(37, 54, Link)
        )
      )
    )

    val output = Output(input.moduleOneInput.text)

    filterManager.execute(input, output).text must_==
      """<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a\nhref="http://bit.ly/xyz">
        |http://bit.ly/xyz </a> @ <a\nhref="http://twitter.com/elversatile">elversatile</a>""".stripMargin
  }
}