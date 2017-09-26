import api._
import module.filters.{EntityFilter, IFilter, LinkFilter, TwitterUsernameFilter}
import module.FormatManager
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

  val formatManager = new FormatManager(filterList)

  def testEntity = {

    val input = List(Rule(0, 5, "Entity"))

    formatManager.execute(input, "Obama") must_== """<strong>Obama</strong>"""
  }

  def testTwitterUsername = {

    val input = List(Rule(0, 12, "TwitterUsername"))

    formatManager.execute(input, "@elversatile") must_== """@ <a href=”http://twitter.com/elversatile”>elversatile</a>"""
  }

  def testLink = {

    val input = List(Rule(0, 17, "Link"))

    formatManager.execute(input, "http://bit.ly/xyz") must_== """<a href=”http://bit.ly/xyz”>http://bit.ly/xyz </a>"""
  }

  def testDefaultExample = {

    val inputList = List(
      Rule(14, 22, "Entity"),
      Rule(0, 5, "Entity"),
      Rule(55, 67, "TwitterUsername"),
      Rule(37, 54, "Link")
    )

    val result = formatManager.execute(inputList, "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile")

    result must_==
      """<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=”http://bit.ly/xyz”>http://bit.ly/xyz </a> @ <a href=”http://twitter.com/elversatile”>elversatile</a>"""
  }
}