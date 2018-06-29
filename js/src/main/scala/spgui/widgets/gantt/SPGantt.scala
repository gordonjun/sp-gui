package spgui.widgets.gantt

import org.scalajs.dom
import scalajs.js
import js.annotation.{ JSGlobal, JSExportAll }

/** FACADE
  * ------
  * This is a facade for the ganttApp.js to create a
  * AngularJS Gantt inside scalajs-react.
  */

// facades "facadedObject" in gui/src/main/resources/ganttApp.js
@js.native
trait SPGantt extends js.Object {
  def setData(rows: js.Array[Row]): Unit = js.native
  def addSomeRow(): Unit = js.native
  def addRow(row: Row): Unit = js.native
  def scroll(dx: Double): Unit = js.native
  // could implement so that callback takes scrolling data, see ganttApp.js and angular-gantt facade
  def onUserScroll(callback: js.Function0[Unit]): Unit = js.native
}
@js.native
@JSGlobal("SPGantt")
object SPGanttJS extends js.Object { // one boilerplate object bc js.natives cannot have real default parameter values
  def apply(element: dom.Element, options: SPGanttOptions): SPGantt = js.native
}
object SPGantt {
  def apply(element: dom.Element, options: SPGanttOptions = SPGanttOptions()) = SPGanttJS(element, options)
}

// TODO I think we should define a couple of convenient scale-alternatives to throw with this object
// then do the tweaking corresponding to each value in ganttApp.js
@JSExportAll
case class SPGanttOptions( // "options" in gui/src/main/resources/ganttApp.js)
                         headers: js.Array[String] = js.Array("hour"), // "day", "hour" etc
                         viewScale: String = "10 minutes" // "day", "2 days", "1 minutes" etc
                         )

@js.native
trait Task extends js.Object { // facades data format of angular-gantt package
  var name: String = js.native
  var from: js.Date = js.native
  var to: js.Date = js.native
  var color: String = js.native // actually js.UndefOr but setting to null gives correct behaviour
}
// atm there is no perfect way to facade "options" kind of jsObjects, but this is one way
object Task {
  def apply(name: String, from: js.Date, to: js.Date, color: String = null): Task = {
    val jsObj = (new js.Object).asInstanceOf[Task]
    jsObj.name = name
    jsObj.from = from
    jsObj.to = to
    jsObj.color = color
    jsObj
  }
}

@js.native
trait Row extends js.Object { // facades data format of angular-gantt package
  var name: String = js.native
  var tasks: js.Array[Task] = js.native
}
object Row {
  def apply(name: String, tasks: js.Array[Task]): Row = {
    val jsObj = (new js.Object).asInstanceOf[Row]
    jsObj.name = name
    jsObj.tasks = tasks
    jsObj
  }
}

