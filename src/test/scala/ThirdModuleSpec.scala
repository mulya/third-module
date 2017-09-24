import api._
import filters.{EntityFilter, LinkFilter, TwitterUsernameFilter}
import module.{IFilter, FilterManager}
import org.specs2.Specification

class ThirdModuleSpec extends Specification { def is = s2"""

 Third module should
   format Entity                    $testEntity
   format TwitterUsername           $testTwitterUsername
   format Link                      $testLink
   format default example           $testDefaultExample
                                                                 """

  val filterList: List[IFilter] = List(
    EntityFilter,
    LinkFilter,
    TwitterUsernameFilter
  )

  val filterManager = new FilterManager(filterList)

  def testEntity = {

    val input = ModuleTwoRule(0, 5, "Entity")

    filterManager.execute(input, "Obama") must_== """<strong>Obama</strong>"""
  }

  def testTwitterUsername = {

    val input = ModuleTwoRule(0, 12, "TwitterUsername")

    filterManager.execute(input, "@elversatile") must_== """@ <a href="http://twitter.com/elversatile">elversatile</a>"""
  }

  def testLink = {

    val input = ModuleTwoRule(0, 17, "Link")

    filterManager.execute(input, "http://bit.ly/xyz") must_== """<a href="http://bit.ly/xyz">http://bit.ly/xyz </a>"""
  }

  def testDefaultExample = {

    val inputList = List(
      ModuleTwoRule(14, 22, "Entity"),
      ModuleTwoRule(0, 5, "Entity"),
      ModuleTwoRule(55, 67, "TwitterUsername"),
      ModuleTwoRule(37, 54, "Link")
    )

    val result = inputList.foldLeft("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile") { (output, rule) =>
      filterManager.execute(rule, output)
    }

    result must_==
      """<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href="http://bit.ly/xyz">
        |http://bit.ly/xyz </a> @ <a href="http://twitter.com/elversatile">elversatile</a>""".stripMargin
  }
}