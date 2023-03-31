name := "Demo"

version := "1.8.2"

scalaVersion := "2.13.10"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

//Compile / unmanagedJars := Seq.empty[sbt.Attributed[java.io.File]]

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.3.2",
  "org.apache.hadoop" % "hadoop-azure" % "3.3.5",
  "org.apache.hadoop" % "hadoop-common" % "3.3.5",
//  "org.apache.hadoop" % "hadoop-client" % "3.3.5",
  "com.microsoft.sqlserver" % "mssql-jdbc" % "12.2.0.jre11"
)