package scalest.admin

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import scalest.ScalestService
import ModelAdminTemplate._

class AdminExtension(modelAdmins: List[ModelAdmin[_]])
  extends ScalestService {

  val header: String = generateHeader(modelAdmins)

  val route: Route = pathPrefix("admin") {
    modelAdmins.map { ma =>
      val html = generateSingleModelHtml(header, ma)
      pathPrefix(ma.modelName) {
        complete(
          HttpEntity(
            ContentTypes.`text/html(UTF-8)`,
            html
          )
        )
      }
    }.reduce(_ ~ _)
  } ~ pathPrefix("api") {
    modelAdmins.map(_.route).reduce(_ ~ _)
  }
  //Todo: Create auth for admin panel
}
