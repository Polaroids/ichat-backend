视频通话用的是 webRTC 平台，我们使用的是基于它的 kurento 媒体服务器，并将 kurento 提供的 demo 移植过来，以实现视频通话功能。

## webrtc介绍：

https://www.jianshu.com/p/19d41dc27325

## kurento-demo 官方文档

https://doc-kurento.readthedocs.io/en/stable/tutorials/java/tutorial-one2one.html

## 按照通讯顺序，websocket 前端与后端(server)消息交互的格式（都是 json

### 登录：告知服务器用户上线了

user -> server 

{
    "type": "login",
    "userID": ""
}


### 登录返回消息（仅在异常的情况下才会发，用于 debug 。正常情况下不处理）

server -> user

{
    "type": "loginResponse",
    "content": "rejected",
    "error": "" // 出错消息
}

### 发起呼叫

caller -> server

{
    "type" : 'call',
    "callerID" : "", // 发起者userID
    "calleeID" : "", // 被呼叫者ID
    "sdpOffer" : ""
}

### 如果对方不在线或是已经在通话中

server -> caller

{
    "type": "callResponse",
    "callResponse": "notOnline" or "inCalling"
}

### 服务器向 callee 发送被呼叫信息

server -> callee

{
    "type": "incomingCall",
    "callerID": "",
    "username":"",
    "avatar":""
}

### callee 处理呼叫信息

callee -> server

{
    "type": "incomingCallResponse",
    "callerID": "",
    "callResponse": "rejected"
}

or

{
    "type": "incomingCallResponse",
    "callerID": "",
    "callResponse": "accepted",
    "sdpOffer": ""
}

### callee 接电话前，caller 主动停止呼叫
caller -> server

{
    "type": "stopCall"
}

#### caller 主动停止呼叫，告诉 callee 有个未接来电，切换状态

server -> callee

{
    "type": "incomingCallStopped"
}

### 服务器收到 callee 的拒绝消息，告诉 caller
server -> caller

{
    "type": "callResponse",
    "callResponse": "rejected"
}

### 如果 callee 长时间未接听，告诉 caller
server -> caller
{
    "type": "callResponse",
    "callResponse": "NotResponse"
}

#### callee 长时间未接听，告诉 callee 有个未接来电
server -> callee

{
    "type": "incomingCallNotResponse"
}

### 服务器收到 callee 的确认消息

服务器开始建立 p2p 媒体管道将双方连接。并向双方发送信息。
这期间服务器还会多次向双方发送 iceCandidate 消息，双方之前也向服务器发送 onIceCandidate 消息.
（iceCandidate集成自己了IP地址信息本地IP地址、公网IP地址、Relay服务端分配的地址等）

##### 服务器告知 callee 开始通话
server -> callee

{
    "type": "startCommunication",
    "sdpAnswer": ""
}

##### 服务器告知 caller 对方接受通话
server -> caller

{
    "type": "callResponse",
    "callResponse": "accepted"
    "sdpAnswer": ""
}

 ##### 如果这期间媒体管道出现异常，并不能开始通话。服务器告知 caller，结束通话
 server -> caller

 {
    "type": "callResponse",
    "callResponse": "exception"
}

##### 前端向服务器发送 onIceCandidate
front -> server

{
    "type": "onIceCandidate"
    "candidate": ""
}

##### 服务器向前端发送 iceCandidate


### 某一方主动结束通话，向服务器发送结束信息
stopper -> server

{
    "type": "stop"
}

### 服务器告诉另一方结束了通话

server -> stoppee

{
    "type": "stopCommmunication",
    "reason": "normal"  // 如果不是normal，则异常中断
}


// 下面临时记一些东西


开启我本地的kurento媒体服务器
docker start 6d54fff652a2ebe4e4f905e5b1be81ba6ac910ddb434a7bc

scp target/ichat-0.0.1-SNAPSHOT.jar root@212.64.78.189:/usr/local/

mvn clean package -DskipTests
