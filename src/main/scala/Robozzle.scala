


class Robozzle {

    type Location = (String, (Int, Int))

    val k = "UP"
    val j = "DOWN"
    val h = "LEFT"
    val l = "RIGHT"

    val directions = Map(k -> (0,1), j->(0, -1), h->(-1,0), l->(1,0))

    def forward (current : Location) : Location = 
        (current._1, (current._2._1 + directions(current._1)._1, 
                      current._2._2 + directions(current._1)._2))
    def left (current: Location) : (String, (Int,Int)) = 
        (h, current._2)

    def verify( location : Location ,
                   goalstars : Seq[Tuple2[Int,Int]] , 
                   moves : Seq[Location => Location]) : Boolean = {

            val lastLocation = moves.foldLeft(Seq(location))( (acc, f) => Seq(f(acc.last) ))

            lastLocation(0)._2 == goalstars(0)
    }

}

