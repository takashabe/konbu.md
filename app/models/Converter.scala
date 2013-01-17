package models

import com.tristanhunt.knockoff._
import com.tristanhunt.knockoff.DefaultDiscounter._

object Converter {
  def markdownToHtml(markdown: String): String = {
    toXHTML(knockoff(markdown)).toString
  }
}
