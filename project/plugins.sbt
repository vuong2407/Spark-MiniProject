addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.1")
resolvers += Resolver.url("sbt-plugin-releases",
  url("https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(
  Resolver.ivyStylePatterns)