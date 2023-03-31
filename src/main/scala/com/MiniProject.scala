package com

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import java.util.Properties

object MiniProject {
  def main(args: Array[String]): Unit = {

    // Define variables for blob storage account and credentials
    val storageAccountName = "vuongnguyen"
    val containerName = "nifi-data"
    val blobName = "mnm_dataset.csv"
    val storageKeyValue = "VoSkdNrypk5juIgXQt6VkGcmUD+u+K5Q8fvwHmhHvUXHKksvh5+3Dpxk8AF8L4wrrqv8D0RaaKT0+AStIqooqA=="

    // Construct the full path to the CSV file in blob storage
//    val blobPath = s"wasbs://${containerName}@${storageAccountName}.blob.core.windows.net/${blobName}"
    val blobPath = s"abfss://${containerName}@${storageAccountName}.dfs.core.windows.net/${blobName}"



    // Define variables for SQL Server connection
    val jdbcUsername = "vuongnguyen"
    val jdbcPassword = "Tma@2022@T1P"

    // Construct the JDBC URL for SQL Server
    val jdbcUrl = s"jdbc:sqlserver://vuongnguyen.database.windows.net:1433;database=SqlDatabase;user=vuongnguyen@vuongnguyen;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
    val connectionProperties = new Properties()
    connectionProperties.put("user", s"${jdbcUsername}")
    connectionProperties.put("password", s"${jdbcPassword}")
    connectionProperties.put("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver")

    // Create a SparkSession
    val spark = SparkSession.builder()
      .appName("Read CSV from Blob Storage")
      .master("local[*]")
      .getOrCreate()

    // config for haddoop
    spark.conf.set("fs.azure.account.auth.type", "SharedKey")
    spark.conf.set(s"fs.azure.account.key.${storageAccountName}.dfs.core.windows.net",  storageKeyValue)
//    spark.conf.set("fs.wasbs.impl", "org.apache.hadoop.fs.azure.NativeAzureFileSystem")
//    spark.conf.set("fs.azure", "org.apache.hadoop.fs.azure.NativeAzureFileSystem")
//    spark.sparkContext.hadoopConfiguration.set("fs.wasbs.impl", "org.apache.hadoop.fs.azure.NativeAzureFileSystem")
//    spark.sparkContext.hadoopConfiguration.set("fs.azure", "org.apache.hadoop.fs.azure.NativeAzureFileSystem")
//    spark.sparkContext.hadoopConfiguration.set(s"fs.azure.account.key.${storageAccountName}.blob.core.windows.net", storageKeyValue)

    // Read the CSV file from blob storage into a DataFrame
    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(blobPath)

    // Group the DataFrame by state and color, and compute the count of total for each group
    df.show(10)

  }

}
