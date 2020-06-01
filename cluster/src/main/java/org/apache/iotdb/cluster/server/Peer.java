/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.cluster.server;

public class Peer {

  private long nextIndex;
  private long matchIndex;
  // only this field will be updated in different thread, as it's value is true or false,
  // so just adding a volatile is enough to face the concurrency problem
  private volatile boolean isCatchUp;

  public Peer(long nextIndex) {
    this.nextIndex = nextIndex;
    this.matchIndex = -1;
    this.isCatchUp = true;
  }

  public long getNextIndex() {
    return nextIndex;
  }

  public void setNextIndex(long nextIndex) {
    this.nextIndex = nextIndex;
  }

  public long getMatchIndex() {
    return matchIndex;
  }

  public void setMatchIndex(long matchIndex) {
    this.matchIndex = matchIndex;
  }

  public boolean isCatchUp() {
    return isCatchUp;
  }

  public void setCatchUp(boolean catchUp) {
    isCatchUp = catchUp;
  }
}