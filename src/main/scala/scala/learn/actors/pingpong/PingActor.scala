package scala.learn.actors.pingpong

import akka.actor.{Actor, ActorRef}

class PingActor () extends Actor {
  override def receive: Receive = {
    case PingPongMessage => {
      println("Ping!")
      Thread.sleep(1000)
      sender() ! PingPongMessage
    }
  }
}
