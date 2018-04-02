
package org.apache.spark.play

import org.apache.spark.SparkEnv
import org.apache.spark.internal.Logging
import org.apache.spark.rpc.{RpcCallContext, RpcEnv, ThreadSafeRpcEndpoint}


case class BriefReport(executorId: Int, executorName: String, uptime: Long)
class CustomEndpoint(env: SparkEnv) extends ThreadSafeRpcEndpoint with Logging{
  override val rpcEnv: RpcEnv = env.rpcEnv


  override def receive: PartialFunction[Any, Unit] = {
    case BriefReport(executorId, executorName, uptime) =>
      logInfo("Brief Report from Executor:")
      logInfo(s"\tExecutor Id: $executorId")
      logInfo(s"\tExecutor Name: $executorName")
      logInfo(s"\tuptime: $uptime")
  }
}

object CustomEndpoint{
  val ENDPOINT_NAME = "CustomEndpoint"
}