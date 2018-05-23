package scala.learn.actors.workers

import akka.actor.{Actor, ActorRef, Cancellable, Props}

import scala.learn.actors.workers.Messages.{DoWork, ScheduleWork, StartAssigningWork, StopWorkAssignment}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class Manager(worker: ActorRef) extends Actor {

  var scheduledRefresh: Cancellable = null
  var counter = 0

  override def receive: Receive = {
    case StartAssigningWork => {
      scheduledRefresh = context.system.scheduler.schedule(0 seconds, 2 seconds, self, ScheduleWork)
    }
    case ScheduleWork => {
      counter += 1
      println("Scheduling work for " + counter)
      worker ! DoWork(counter)
    }
    case StopWorkAssignment => {
      println("Received stop work assignment message")
      scheduledRefresh.cancel()
    }
  }
}
