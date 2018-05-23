package scala.learn.actors.pingpong

import akka.actor.{ActorRef, ActorSystem, Props}

object PingPongApp extends App {

  val system: ActorSystem = ActorSystem()

  val pong: ActorRef = system.actorOf(Props(new PongActor()), "pong-actor")

  val ping: ActorRef = system.actorOf(Props(new PingActor()), "ping-actor")

  ping.tell(PingPongMessage, pong)
}
