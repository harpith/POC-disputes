

---

📘 Hybrid Workstation Flow Tracker

💡 Overview

Hybrid Workstation Flow Tracker is a system designed to capture and visualize the execution flow across a complex application environment consisting of:

JSP (legacy UI)

React Micro Frontends (iframes)

Spring Boot Microservices

External JAR executions


Instead of analyzing source code, this project captures runtime events and reconstructs the actual execution path as a dynamic flowchart (execution graph).


---

🧠 Problem Statement

Modern enterprise applications often combine legacy and modern technologies, leading to:

❌ No clear visibility of execution flow

❌ Difficult debugging across layers

❌ Lack of end-to-end tracing

❌ Complex microservice interactions



---

🎯 Objective

To build a system that:

Tracks interactions across all layers

Reconstructs execution flow dynamically

Visualizes flow as a graph/flowchart

Works without AI or code parsing

Supports hybrid architectures



---

🧱 Core Concept

> We do NOT analyze code. We capture runtime events.



Each component (JSP, MFE, Backend, JAR) emits structured events, which are:

1. Collected centrally


2. Stored


3. Linked sequentially


4. Converted into a flow graph




---

🔄 System Flow

User Action
   ↓
JSP Page
   ↓
React MFE (iframe)
   ↓
Backend API
   ↓
Service Layer
   ↓
JAR Execution

Each step generates an event.


---

⚙️ System Architecture

🟢 Frontend (JSP + React)

Captures:

Page loads

User interactions

API calls


Example:

logEvent("PAGE_LOAD", "/home.jsp");


---

🔵 Backend (Spring Boot Microservices)

Tracks:

API calls (Interceptor)

Method calls (AOP)

JAR executions (Wrapper)



---

🟡 Tracking Service (Core Engine)

Responsibilities:

Receive events via API

Store events in database

Build execution flow



---

🗄️ Database

Stores structured events:

{
  "sessionId": "123",
  "source": "MFE",
  "target": "/getUser",
  "type": "API_CALL",
  "timestamp": 123456
}


---

📊 Flow Builder

Sorts events by timestamp

Connects events sequentially

Generates graph structure



---

🎨 UI (Flowchart Viewer)

Displays:

JSP → MFE → API → METHOD → JAR


---

🔗 Event Flow Example

Step	Event Type	Source	Target

1	PAGE_LOAD	JSP	/home.jsp
2	MFE_LOAD	MFE	iframe
3	API_CALL	MFE	/getUser
4	METHOD_CALL	Backend	getUserService()
5	JAR_EXECUTION	Backend	report.jar



---

🔄 Flow Construction Logic

Events are sorted by timestamp

Each event becomes a node

Consecutive events form edges


JSP → MFE → API → METHOD → JAR


---

🧠 Key Concepts

Nodes = Events

Edges = Execution sequence

Session ID = Flow grouping

Graph = Final visualization



---

⚙️ Selective Tracking

To reduce noise:

✅ API filtering (specific endpoints)

✅ Annotation-based tracking (@TrackFlow)

✅ Header-based dynamic tracking



---

🔥 Key Features

✅ Works with legacy + modern systems

✅ No AI required

✅ Minimal code changes

✅ Real-time flow tracking

✅ Scalable architecture

✅ Technology-independent



---

⚠️ Challenges

Session tracking across layers

High volume of events

Performance optimization

Event correlation accuracy



---

🚀 Implementation Plan

Phase 1: Basic Setup

Create tracking API

Send test events

Log output


Phase 2: Backend Integration

Add interceptor

Store events in DB


Phase 3: Flow Logic

Build event linking mechanism


Phase 4: Visualization

Create flowchart UI


Phase 5: Optimization

Add filtering & annotations



---

🗣️ Final Explanation

> This project captures runtime events across JSP, micro frontends, backend services, and JAR executions. These events are collected by a central tracking service and transformed into a flow graph, providing a real-time view of the system’s execution path without analyzing source code or using AI.




---

🎯 One-Line Summary

👉 Track events → connect them → visualize flow


---

💥 Use Cases

Debugging complex systems

Understanding execution flow

Monitoring microservices

Analyzing legacy-modern integrations



---

🔮 Future Enhancements

Real-time flow streaming

Error highlighting in graph

Performance bottleneck detection

Distributed tracing integration

