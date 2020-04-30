package main.scala.com.bigdata.app

import org.apache.spark.sql.SparkSession

object SparkScalaDatasetCreationUsingCaseClass{

  def main(args:Array[String]): Unit ={

    val spark = SparkSession.builder.master("local").appName("Employee Operations").config("spark.some.config.option", "some-value").getOrCreate
    import spark.implicits._
    val empData = Seq( Employee("Anto",21, "Software Engineer", 20000.00, 90503))
    val empDataFrame = empData.toDF
    empDataFrame.show()

  }




}
