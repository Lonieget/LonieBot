# 🤖 LonieBot - LINE x Gemini AI 智慧聊天機器人

LonieBot 是一款基於 **Spring Boot 3.x** 開發的 LINE 聊天機器人，整合了 **Google Gemini Pro** 模型。它能即時接收 LINE 使用者的訊息，透過 AI 生成智慧回覆並回傳給使用者，打造流暢且現代化的對話體驗。

---

## 🚀 核心功能
* **AI 智慧對話**：串接最新 Google Gemini API，提供自然且準確的語言處理。
* **Webhook 整合**：採用 LINE Messaging SDK 3.x 異步處理機制。
* **動態配置管理**：透過 `application.properties` 靈活管理 API 金鑰。
* **後端驅動**：基於 Java 生態系構建，具備高度擴充性。

## 🛠️ 技術棧
* **後端框架**: Spring Boot 3.x
* **程式語言**: Java 17+
* **SDK**: LINE Messaging API SDK for Java (v3.x)
* **AI 模型**: Google Gemini Pro API
* **建構工具**: Maven
* **資料庫**: MySQL (相容 8.0+)

---

## 📦 快速開始

### 1. 環境準備
* **JDK 17** 或更高版本。
* **Maven 3.6+**。
* 一個 **LINE Developers** 帳號，並建立 Messaging API Channel。
* 一個 **Google AI Studio** 帳號，獲取 Gemini API Key。

### 2. 設定檔配置
請在 `src/main/resources/application.properties` 中填入你的金鑰（請務必妥善保管）：

```properties
spring.application.name=LonieBot

# LINE Developers 設定
line.bot.channel-token=${YOUR_CHANNEL_ACCESS_TOKEN}
line.bot.channel-secret=${YOUR_CHANNEL_SECRET}
line.bot.handler.path=/callback

# Gemini AI 設定
gemini.api-key=${YOUR_GEMINI_API_KEY}

# 資料庫設定
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password

專案架構
Plaintext
src/main/java/
└── com/lonie/bot/
    ├── controller/      # Webhook 控制器 (處理 LINE 事件)
    ├── service/         # Gemini API 呼叫邏輯 (包含 RestTemplate 實作)
    ├── model/           # 資料實體與 DTO
    └── config/          # Bean 配置與 RestTemplate 設定
# 進入專案目錄
cd LonieBot

# 編擬並執行
mvn spring-boot:run

安全提醒
重要：請勿將包含真實 API Key 的 application.properties 上傳至公共儲存庫。

建議使用 .gitignore 排除敏感設定檔，或改用環境變數注入 Secret。

👤 作者
Lonie (鄭宇翔)

全端開發工程師 (Full-stack Developer)

擅長技術：Angular、Spring Boot、Java、AI 應用整合。
