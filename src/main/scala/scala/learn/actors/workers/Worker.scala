package scala.learn.actors.workers

import akka.actor.{Actor, ActorRef}

import scala.learn.actors.workers.Messages.{DoWork, Terminate}

class Worker() extends Actor {

  var manager: ActorRef = null

  override def receive: Receive = {
    case DoWork(id) => {
      manager = sender()
      println("Received work: " + id)
      Thread.sleep(1000)
      println("Done work: " + id)
    }
    case Terminate => {
      println("Received terminate")
      manager ! Messages.StopWorkAssignment
    }
  }
}
