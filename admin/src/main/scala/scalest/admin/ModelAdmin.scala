package scalest.admin

import akka.http.scaladsl.server.{Directives, Route}
import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport
import io.circe.{Decoder, Encoder}

//Todo: Entities relations
class ModelAdmin[Model: Encoder : Decoder, Id: Encoder : Decoder](val crudRepository: CrudRepository[Model, Id],
                                                                  val modelView: ModelView[Model])

  extends Directives with ModelAdminTemplate with ModelAdminScript with ErrorAccumulatingCirceSupport {

  val template: Template = generateTemplate(this)

  val script: String = generateScript(this)

  //Todo: Server-Side Pagination operation
  //Todo: Search operation
  //Todo: Custom Actions endpoint operation
  //Todo: Delete Selected operation
  //Todo: Entity Validation using annotations
  val route: Route = pathPrefix(s"${modelView.modelName}s") {
    (get & pathEndOrSingleSlash) {
      complete(crudRepository.findAll())
    } ~
      (post & pathEndOrSingleSlash) {
        entity(as[Model])(m => complete(crudRepository.create(m)))
      } ~
      (put & pathEndOrSingleSlash) {
        entity(as[Model])(m => complete(crudRepository.update(m)))
      } ~
      (delete & pathEndOrSingleSlash) {
        entity(as[Seq[Id]])(ids => complete(crudRepository.delete(ids)))
      }
  }
}

object ModelAdmin {
  def apply[Model: Encoder : Decoder : ModelView, Id: Encoder : Decoder](crudRepository: CrudRepository[Model, Id]): ModelAdmin[Model, Id] = new ModelAdmin(
    crudRepository = crudRepository,
    modelView = implicitly
  )
}