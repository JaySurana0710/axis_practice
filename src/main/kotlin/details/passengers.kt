package details


import java.sql.DriverManager
import java.sql.PreparedStatement
import java.util.Scanner
import kotlin.concurrent.thread

val sc = Scanner(System.`in`)
val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineticketbooking","root","jaysurana")

data class passengers(val passenger_id:Int, val passenger_name:String, val passenger_age:Int, val gender:Char, val Phone:String)



fun insertpassenger(){
    print("\nEnter Data\nName : ")
    val passenger_name = sc.next()
    print("Age : ")
    val passenger_age = sc.nextInt()
    print("Gender (M/F) : ")
    val gender = sc.next();
    print("Contact Number : ")
    val phone = sc.next()
    val pstmt = connection.prepareStatement("Insert into passengers(passenger_name,passenger_age,gender,phone) values(?,?,?,?)")
    pstmt.setString(1,passenger_name)
    pstmt.setInt(2,passenger_age)
    pstmt.setString(3,gender)
    pstmt.setString(4,phone)
    pstmt.executeUpdate()


}
fun deletepassenger(){
    print("Enter passenger id to be deleted : ")
    var delid = sc.nextInt()
    val query = connection.prepareStatement("delete from passengers where passenger_id=?")
    query.setInt(1,delid)
    query.executeUpdate()
    println("Deleted passenger with id $delid")
}
fun showallpassenger() {
    val query1 = connection.prepareStatement("select * from passengers")
    val result1 = query1.executeQuery()
    while (result1.next()) {
        val id = result1.getInt("passenger_id")
        val name = result1.getString("passenger_name")
        val age = result1.getInt("passenger_age")
        val gender = result1.getString("gender")
        val phone = result1.getString("phone")
        println("---------------------------\nId : $id\nName : $name\nAge : $age\nGender : $gender\nContact Number : $phone\n---------------------------")

    }
    Thread.sleep(4000)
}
fun main() {
    while(true){
        print("\n1. Insert\n2. Delete\n3. Show All Entries\n4. Exit\nEnter your choice : ")
        var choice = sc.nextInt()
        when (choice) {
            1 -> insertpassenger()
            2 -> deletepassenger()
            3 -> showallpassenger()
            4 ->break
        }
    }

}