package controllers

import play.api._
import play.api.mvc._
import models.Converter

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def konbu = Action {
    implicit request =>
      request.body.asFormUrlEncoded match {
        case Some(x) => {
          // Map(String, Seq[String])であるため2回headが必要
          val text = Converter.markdownToHtml(x.values.head.head)
          Logger.debug(text)
          Ok(text)
        }
        case None => BadRequest("Request body is None.")
      }
  }

}