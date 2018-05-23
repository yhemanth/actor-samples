package scala.learn.actors.pingpong

import akka.actor.Actor

class PongActor extends Actor {
  override def receive: Receive = {
    case PingPongMessage => {
      println("Pong!")
      Thread.sleep(1000)
      sender() ! PingPongMessage
    }
  }
}
