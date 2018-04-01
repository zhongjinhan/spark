
package org.apache.spark.play

import org.apache.spark.SparkEnv
import org.apache.spark.rpc.{RpcEnv, ThreadSafeRpcEndpoint}

class CustomEndpoint(env: SparkEnv) extends ThreadSafeRpcEndpoint {
  override val rpcEnv: RpcEnv = env.rpcEnv

}
