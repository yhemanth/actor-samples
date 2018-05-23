package scala.learn.actors.workers

import akka.actor.{ActorRef, ActorSystem, Props}

object WorkerApp extends App {

  val system: ActorSystem = ActorSystem()

  val worker: ActorRef = system.actorOf(Props(new Worker), "worker")
  val manager: ActorRef = system.actorOf(Props(new Manager(worker)), "manager")

  manager ! Messages.StartAssigningWork
  Thread.sleep(10000)
  println("Sending a shutdown")
  worker ! Messages.Terminate
}
