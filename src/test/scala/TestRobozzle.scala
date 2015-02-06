import org.scalatest.FunSuite

class TestRobozzle extends FunSuite {
   
        val robozzle = new Robozzle
        
    test ("no move will fail") {
        val result = robozzle.verify(
            (robozzle.k, (0, 0)),
            List((1, 0)),
            List())
        assert(result == false)
    }

    test ("return true if starting point equals to goalstar") {
        val result = robozzle.verify(
            (robozzle.k, (0, 0)),
            List((0, 0)),
            List())
        assert(result == true)
    }

    test ("should return true when move 1 forward to the goalstar ") {
        val result = robozzle.verify(
            (robozzle.k, (0, 0)),
            List((0, 1)),
            List(robozzle.forward))
        assert(result == true)
    }

    test ("going down") {
        val result = robozzle.verify(
            (robozzle.j, (0, 0)),
            List((0, -1)),
            List(robozzle.forward))
        assert(result == true)
    }
    
    test ("going left") {
        val result = robozzle.verify(
            (robozzle.h, (0, 0)),
            List((-1, 0)),
            List(robozzle.forward))
        assert(result == true)
    }
    
    test ("going right") {
        val result = robozzle.verify(
            (robozzle.l, (0, 0)),
            List((1, 0)),
            List(robozzle.forward))
        assert(result == true)
    }

    test ("turn left") {
        val result = robozzle.verify(
            (robozzle.k, (0, 0)),
            List((-1, 0)),
            List(robozzle.left, robozzle.forward))
        assert(result == true)
    }

}
