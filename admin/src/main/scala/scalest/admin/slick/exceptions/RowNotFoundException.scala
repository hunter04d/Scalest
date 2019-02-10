package scalest.admin.slick.exceptions

class RowNotFoundException[T](notFoundRecord: T)
  extends ActiveSlickException(s"Row not found: $notFoundRecord")