package scalest.admin.slick.exceptions

class TooManyRowsAffectedException(affectedRowCount: Int, expectedRowCount: Int)
  extends ActiveSlickException(s"Expected $expectedRowCount row(s) affected, got $affectedRowCount instead")
