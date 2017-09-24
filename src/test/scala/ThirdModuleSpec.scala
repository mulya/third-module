import api._
import filters.{EntityFilter, LinkFilter, TwitterUsernameFilter}
import module.{IFilter, FilterManager}
import org.specs2.Specification

class ThirdModuleSpec extends Specification { def is = s2"""

 Third module should
   format Entity                    $testEntity
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

//  def testTwitterUsername = {
//
//    val input = Input(
//      ModuleOneInput(
//        "@elversatile"
//      ),
//      ModuleTwoInput(
//        List(
//          ModuleTwoRule(0, 12, TwitterUsername)
//        )
//      )
//    )
//
//    val output = Output(input.moduleOneInput.text)
//
//    filterManager.execute(input, output).text must_== """@ <a href="http://twitter.com/elversatile">elversatile</a>"""
//  }
//
//  def testLink = {
//
//    val input = Input(
//      ModuleOneInput(
//        "http://bit.ly/xyz"
//      ),
//      ModuleTwoInput(
//        List(
//          ModuleTwoRule(0, 17, Link)
//        )
//      )
//    )
//
//    val output = Output(input.moduleOneInput.text)
//
//    filterManager.execute(input, output).text must_== """<a href="http://bit.ly/xyz">http://bit.ly/xyz </a>"""
//  }
//
//  def testDefaultExample = {
//
//    val input = Input(
//      ModuleOneInput(
//        "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"
//      ),
//      ModuleTwoInput(
//        List(
//          ModuleTwoRule(14, 22, Entity),
//          ModuleTwoRule(0, 5, Entity),
//          ModuleTwoRule(55, 67, TwitterUsername),
//          ModuleTwoRule(37, 54, Link)
//        )
//      )
//    )
//
//    val output = Output(input.moduleOneInput.text)
//
//    filterManager.execute(input, output).text must_==
//      """<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href="http://bit.ly/xyz">
//        |http://bit.ly/xyz </a> @ <a href="http://twitter.com/elversatile">elversatile</a>""".stripMargin
//  }
}