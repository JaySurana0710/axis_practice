package details

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.util.Scanner
import javax.print.attribute.standard.Destination
import kotlin.concurrent.thread

data class train(val train_id:Int,val train_number:Int, val train_name:String, val source:String, val destination:String, val start_date_time:String, val arrival_time:String)




//fun inserttrain(){
//    print("\nEnter Data\nName : ")
//    val train_name = sc.next()
//    print("Age : ")
//    val passenger_age = sc.nextInt()
//    print("Gender (M/F) : ")
//    val gender = sc.next();
//    print("Contact Number : ")
//    val phone = sc.next()
//    val pstmt = connection.prepareStatement("Insert into passengers(passenger_name,passenger_age,gender,phone) values(?,?,?,?)")
//    pstmt.setString(1,passenger_name)
//    pstmt.setInt(2,passenger_age)
//    pstmt.setString(3,gender)
//    pstmt.setString(4,phone)
//    pstmt.executeUpdate()
//
//
//}
//fun deletetrain(){
//
//}
//fun showalltrain() {
//    val query1 = connection.prepareStatement("select * from train")
//    val result1 = query1.executeQuery()
//    while (result1.next()) {
//        val id = result1.getInt("passenger_id")
//        val name = result1.getString("passenger_name")
//        val age = result1.getInt("passenger_age")
//        val gender = result1.getString("gender")
//        val phone = result1.getString("phone")
//        println("---------------------------\nId : $id\nName : $name\nAge : $age\nGender : $gender\nContact Number : $phone\n---------------------------")
//
//    }
//    Thread.sleep(4000)
//}
fun showalldatatrain(){
    val query1 = connection.prepareStatement("select * from train")
    val result1 = query1.executeQuery()

    while (result1.next()) {
        val train_id = result1.getInt("train_id")
        val train_number = result1.getString("train_number")
        val train_name = result1.getString("train_name")
        val source = result1.getString("source")
        val destination = result1.getString("destination")
        val start_date_time = result1.getString("start_date_time")
        val arrival_time = result1.getString("arrival_time")
        println("$train_id\n$train_number\n$train_name\n$source\n$destination\n$start_date_time\n$arrival_time")
    }
}

fun main() {
    val res = connection.createStatement().executeUpdate("Insert into train(train_id,train_number,train_name,source,destination,start_date_time,arrival_time) values(1,67543,'KK Express','Delhi','Bangalore','2022-08-03 06:00:00','2022-08-04 12:00:00')")
    if (res>0){
        println("Insert Executed Successfully")
    }else{
        println("Insert Unsuccessful")
    }
    showalldatatrain()

    val update_res = connection.createStatement().executeUpdate("update train set train_name='Aravali Express' where train_id=1")
    if (update_res>0){
        println("Update Executed Successfully")
    }else{
        println("Update Unsuccessful")
    }
    showalldatatrain()
//    val del = connection.createStatement().executeUpdate("Delete from train where train_id = 1")
//    if (del>0){
//        println("Delete Successful")
//    }else{
//        println("Delete Unsuccessful")
//    }


}