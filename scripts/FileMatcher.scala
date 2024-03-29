object FileMatcher {
  private def files = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: (String) => Boolean) =
    for (file <- files if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}
