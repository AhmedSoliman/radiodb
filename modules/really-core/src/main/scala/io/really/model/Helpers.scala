/**
 * Copyright (C) 2014-2015 Really Inc. <http://really.io>
 */
package io.really.model

import _root_.io.really.{ ReallyConfig, BucketID, R }

object Helpers {
  def getBucketIDFromR(r: R)(implicit config: ReallyConfig): BucketID = {
    require(r.isObject, "R doesn't contain an ID")
    r.skeleton.actorFriendlyStr + "-" + (r.head.id.get % config.Sharding.bucketsNumber)
  }

  def getRFromBucketID(bucketID: BucketID): R = {
    R(bucketID.replace("_", "/").split('-')(0))
  }
}
