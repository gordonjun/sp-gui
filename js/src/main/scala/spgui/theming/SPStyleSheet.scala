package spgui.theming

import scalacss.DevDefaults._

object Theming {
  trait SPStyleSheet extends StyleSheet.Inline {
    import spgui.circuit.SPGUICircuit
    val theme = SPGUICircuit.zoom(_.settings.theme)
    import dsl._

    // rgb numbers need to be converted to tuples to be handled by rgb()
    def _rgb(c:Int) = rgb(
      (c & 0xff0000) >> 16,
      (c & 0x00ff00) >> 8,
      (c & 0x0000ff)
    )

    // separate alpha value tacked on
    def _rgba(c:Int, a: Int) = rgba(
      (c & 0xff0000) >> 16,
      (c & 0x00ff00) >> 8,
      (c & 0x0000ff),
      a
    )

    def _rgba(c:Int) = rgba(
      (c & 0xff000000) >> 24,
      (c & 0x00ff0000) >> 16,
      (c & 0x0000ff00) >> 8,
      (c & 0x000000ff)
    )
  }

  case class Theme (
                     name:                             String = "default",
                     borderless:                       Boolean = false,
                     mainBackgroundColor:              Int = 0x3F495B,
                     defaultTextColor:                 Int = 0xdf691a,
                     spOrange:                         Int = 0xdf691a,
                     lightSPOrange:                    Int = 0xefb58e,
                     lighterSPOrange:                  Int = 0xefb58e,
                     lightestSPOrange:                 Int = 0xffc69f,

                     navbarBackgroundColor:            Int = 0x1F2739,
                     navbarLogoBackgroundColor:        Int = 0xdf691a,
                     navbarButtonBackgroundHoverColor: Int = 0x2c3a59,
                     navbarButtonTextColor:            Int = 0x000000,

                     widgetBackgroundColor:            Int = 0x2F384A,
                     widgetHeadingColor:               Int = 0xa8f1ff,
                     widgetTextColor:                  Int = 0xebf5ff,
                     widgetHeadingIconColor:           Int = 0xffffff,

                     widgetButtonBorderColor:          Int = 0xaaaaaa,
                     widgetButtonBackgroundColor:      Int = 0xdddddd,
                     widgetButtonBackgroundHoverColor: Int = 0xffffff,
                     widgetButtonTextColor:            Int = 0x000000,
                     shadow: String = "1px 2px 2px rgba(0, 0, 0, 0.1), 0 1px 0 rgba(0, 0, 0, 0.1)"
                   )

  def themeList: List[Theme] = List(
    Theme(
      // default: all variables unchanged
    ),
    Theme(
      name =                                "old",
      borderless  =                       false,
      mainBackgroundColor  =              0xbbbbbb,
      defaultTextColor  =                     0x000000,
      spOrange  =                             0xdf691a,

      navbarBackgroundColor  =                0xcccccc,
      navbarLogoBackgroundColor  =            0xdf691a,
      navbarButtonBackgroundHoverColor  =   0xbbbbbb,
      navbarButtonTextColor  =              0x000000,

      widgetBackgroundColor  =              0xededed,
      widgetHeadingColor  =                 0x999999,
      widgetHeadingIconColor  =             0xffffff,

      widgetButtonBorderColor  =            0xaaaaaa,
      widgetButtonBackgroundColor  =        0xdddddd,
      widgetButtonBackgroundHoverColor  =   0xffffff,
      widgetButtonTextColor  =              0x000000,
    ),
    Theme(
      name =                                "dark",
      borderless =                          false,
      defaultTextColor =                    0xffffaa,
      mainBackgroundColor=                  0x222222,

      navbarBackgroundColor =               0x222222,
      navbarLogoBackgroundColor =           0xdf691a,
      navbarButtonBackgroundHoverColor =    0x555555,
      navbarButtonTextColor  =              0xffffff,

      widgetBackgroundColor =               0x333333,
      widgetHeadingColor =                  0x222222,
      widgetHeadingIconColor =              0xffffff,

      widgetButtonBorderColor =             0xaaaaaa,
      widgetButtonBackgroundColor =         0x222222,
      widgetButtonBackgroundHoverColor =    0x333333,
      widgetButtonTextColor =               0xffffff
    ),
    Theme(
      name = "light",
      borderless = false,
      defaultTextColor =                    0x000000,
      mainBackgroundColor=                  0xffffff,

      navbarBackgroundColor =               0xeeeeee,
      navbarLogoBackgroundColor =           0xdf691a,
      navbarButtonBackgroundHoverColor =    0xdddddd,
      navbarButtonTextColor  =              0x000000,

      widgetBackgroundColor =               0xf5f5f5,
      widgetHeadingColor =                  0xeeeeee,
      widgetHeadingIconColor =              0x000000,

      widgetButtonBorderColor =             0xffffff,
      widgetButtonBackgroundColor =         0xffffff,
      widgetButtonBackgroundHoverColor =    0xeeeeee,
      widgetButtonTextColor =               0x000000
    )
  )
}

