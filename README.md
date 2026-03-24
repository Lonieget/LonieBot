# 🦷 LonieBot - AI 聊天機器人

[![Java Version](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![LINE SDK](https://img.shields.io/badge/LINE%20SDK-8.7.0-blue.svg)](https://github.com/line/line-bot-sdk-java)

## 📌 專案簡介
**LonieBot** 是一款結合 **Spring Boot** 與 **LINE Messaging API** 的聊天機器人。旨在透過自動化回覆系統，協助牙醫診所處理病患的初步諮詢與掛號引導。目前已實作基礎通訊架構，並預計整合 **Google Gemini AI** 進行自然語言處理（NLP），讓機器人具備專業的衛教諮詢能力。

---

## 🛠️ 技術核心 (Technical Highlights)

### 1. 後端架構設計
* **核心框架**：採用 **Spring Boot 3.4.3**，利用其強大的 Dependency Injection (DI) 與 Bean 管理特性。
* **Webhook 處理**：透過 `@LineMessageHandler` 監聽 LINE 伺服器發出的 POST 請求，並實作 `@EventMapping` 進行精準的訊息事件分發。
* **網路穿透**：使用 **ngrok** 建立安全隧道 (Tunneling)，解決本地端開發環境與外部 API 通訊的障礙。

### 2. 進階環境優化 (Problem Solving)
* **依賴管理優化**：針對開發環境中 Gradle 遠端倉庫抓取失敗的挑戰，實作了 **Local JAR Loading** 機制，確保專案建置的穩定性。
* **建置指令**：熟練使用 `gradlew clean build --refresh-dependencies` 進行專案重構與緩存清理。

---

## 🚀 專案亮點與解決問題

### 🔍 挑戰：解決版本遷移與依賴衝突
在開發過程中，遇到了 SDK 版本不相容與網路連線問題：
* **問題**：最新版 SDK (v9.x) 的 `TextMessage.builder()` 在特定環境下編譯異常，且遠端倉庫連線不穩定。
* **解決方案**：
  1. **手動掛載**：手動建立 `libs/` 目錄，將 `line-bot-spring-boot-starter-8.7.0.jar` 導入，並修改 `build.gradle` 的 `fileTree` 配置。
  2. **程式重構**：將 Controller 邏輯改為 8.x 系列的建構子模式 (`new TextMessage()`)，成功恢復系統運作。

---

## 📋 功能清單 (Feature List)
- [x] **即時回覆系統**：自動接收病患訊息並回傳確認通知。
- [x] **Webhook 安全驗證**：成功通過 LINE Channel 伺服器驗證 (Status 200)。
- [ ] **Gemini AI 整合**：預計實作智慧衛教對話，提供病患診療流程諮詢。
- [ ] **掛號預約系統**：規劃串接資料庫（MySQL/H2）儲存病患預約時段。

---

## 📂 專案結構
```text
LonieBot
├── libs/                     # 手動掛載的 LINE SDK JAR 檔
├── src/main/java/com/example/LonieBot/
│   ├── LonieBotApplication.java # Spring Boot 啟動進入點
│   └── controller/              # 負責處理 LINE Webhook 邏輯
├── src/main/resources/
│   └── application.properties    # LINE Channel Secret/Token 配置
└── build.gradle                 # 專案建置與本地依賴配置
