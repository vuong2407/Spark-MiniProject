name := "Demo"

version := "1.8.2"

scalaVersion := "2.12.15"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

Compile / unmanagedJars := Seq.empty[sbt.Attributed[java.io.File]]

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.3.2",
  "org.apache.spark" %% "spark-sql" % "3.3.2",
  "org.apache.hadoop" % "hadoop-azure" % "3.3.5",
  "org.apache.hadoop" % "hadoop-common" % "3.3.5",
  "org.apache.hadoop" % "hadoop-core" % "1.2.1",
  "com.microsoft.sqlserver" % "mssql-jdbc" % "7.2.1.jre8",
)