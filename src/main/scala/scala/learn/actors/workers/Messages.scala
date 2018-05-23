package scala.learn.actors.workers

object Messages {

  case class DoWork(id: Long)
  case class Terminate()
  case class StopWorkAssignment()
  case class StartAssigningWork()
  case class ScheduleWork()
}
