package com.example.LonieBot.Handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.linecorp.bot.messaging.model.TextMessage;
import com.linecorp.bot.spring.boot.handler.annotation.EventMapping;
import com.linecorp.bot.spring.boot.handler.annotation.LineMessageHandler;
import com.linecorp.bot.webhook.model.Event;
import com.linecorp.bot.webhook.model.MessageEvent;
import com.linecorp.bot.webhook.model.TextMessageContent;

import jakarta.annotation.PostConstruct;

@Component
@LineMessageHandler
public class MyLineBotHandler {

	@Value("${gemini.api-key}")
	private String geminiApiKey;

	private Client client;

	@PostConstruct
	public void init() {
		this.client = Client.builder().apiKey(geminiApiKey).build();
	}

	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent event) {
		if (event.message() instanceof TextMessageContent userMsg) {
			String userText = userMsg.text();

			System.out.println("收到使用者訊息：" + userText);

			try {
				// ⭐ 最重要：使用正確的模型 ID
				GenerateContentResponse response = client.models.generateContent("gemini-2.5-flash", // 2025 最新、保證能用
						userText, null);

				String aiResponse = response.text();

				System.out.println("AI 回覆：" + aiResponse);

				return new TextMessage(aiResponse != null ? aiResponse : "AI 沒有回覆內容");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
				if (e.getMessage().contains("429")) {
					return new TextMessage("Lonie Bot 接收太多資訊有點當機了，請稍等一分鐘再跟我聊天喔！");
				}
				return new TextMessage("系統忙碌中，請稍後再試。");
			}

		}
		return null;
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		System.out.println("收到非文字事件: " + event);
	}
}