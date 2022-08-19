package details

data class ticket(val ticket_id:Int, val ticket_number:Int,val passenger_id:Int,val train_id:Int,val ticket_price:Int)
fun showalldataticket(){
    val query1 = connection.prepareStatement("select * from ticket")
    val result1 = query1.executeQuery()

    while (result1.next()) {
        val ticket_id = result1.getInt("ticket_id")
        val ticket_number = result1.getInt("ticket_number")
        val passenger_id = result1.getInt("passenger_id")
        val train_id = result1.getInt("train_id")
        val ticket_price = result1.getInt("ticket_price")
        println("$ticket_id\n$ticket_number\n$passenger_id\n$train_id\n$ticket_price\n")
    }
}
fun main(args: Array<String>) {

    val res = connection.createStatement().executeUpdate("Insert into ticket(ticket_number,passenger_id,train_id,ticket_price) values(67676,1,1,1700)")
    if (res>0){
        println("Insert Executed Successfully")
    }else{
        println("Insert Unsuccessful")
    }
    showalldataticket()

    val update_res = connection.createStatement().executeUpdate("update ticket set ticket_price=1800 where ticket_id=1")
    if (update_res>0){
        println("Update Executed Successfully")
    }else{
        println("Update Unsuccessful")
    }
    showalldataticket()
//    val del = connection.createStatement().executeUpdate("Delete from ticket where ticket_id = 1")
//    if (del>0){
//        println("Delete Successful")
//    }else{
//        println("Delete Unsuccessful")
//    }


}