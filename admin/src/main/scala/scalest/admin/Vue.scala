package scalest.admin

import scalatags.Text.all._

import scala.language.implicitConversions

object Vue {

  implicit def attrToAttrPair(attr: Attr): AttrPair = attr.empty

  lazy val emptyFrag: Frag = ""

  lazy val vColor = attr("color")

  lazy val vImg = tag("v-img")

  lazy val vToolbarSideIcon = tag("v-toolbar-side-icon")

  lazy val vMenu = tag("v-menu")

  lazy val vList = tag("v-list")

  lazy val vListTile = tag("v-list-tile")

  lazy val vListTileTitle = tag("v-list-tile-title")

  lazy val vSelect = tag("v-select")

  lazy val vToolbarTitle = tag("v-toolbar-title")

  lazy val vDivider = tag("v-divider")

  lazy val vDialog = tag("v-dialog")

  lazy val vCardTitle = tag("v-card-title")

  lazy val vCardText = tag("v-card-text")

  lazy val vLayout = tag("v-layout")

  lazy val vFlex = tag("v-flex")

  lazy val vCardActions = tag("v-card-actions")

  lazy val vDataTable = tag("v-data-table")

  lazy val vTemplate = tag("template")

  lazy val vCheckbox = tag("v-checkbox")

  lazy val vSwitch = tag("v-switch")

  lazy val vTextField = tag("v-text-field")

  lazy val vBtn = tag("v-btn")

  lazy val `@click` = attr("@click", raw = true)

  lazy val vIcon = tag("v-icon")

  lazy val vSpacer = tag("v-spacer")

  lazy val vToolbar = tag("v-toolbar")

  lazy val vSnackbar = tag("v-snackbar")

  lazy val vContainer = tag("v-container")

  lazy val vContent = tag("v-content")

  lazy val vApp = tag("v-app")

  lazy val vCard = tag("v-card")


  def vBind(attrb: String): Attr = attr(s"v-bind:$attrb")


  lazy val vModel: Attr = attr("v-model")


  lazy val vShow: Attr = attr("v-show")


  lazy val vIf: Attr = attr("v-if")


  lazy val vElseIf: Attr = attr("v-else-if")


  lazy val vElse: AttrPair = attr("v-else").empty


  lazy val vFor: Attr = attr("v-for")


  lazy val vOn: Attr = attr("v-on")


  def vOn(event: String): Attr = attr(s"v-on:$event")


  lazy val vPre: AttrPair = attr("v-pre").empty


  lazy val vCloak: AttrPair = attr("v-cloak").empty


  lazy val vOnce: AttrPair = attr("v-once").empty
}
